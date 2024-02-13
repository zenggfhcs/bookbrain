package com.lib.bookbrain.aop;

import com.lib.bookbrain.constant.LogType;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.LogMapper;
import com.lib.bookbrain.dao.TokenAccessRecordMapper;
import com.lib.bookbrain.fnuction.TriConsumer;
import com.lib.bookbrain.model.BaseEntity;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.TokenBody;
import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.entity.TokenUsedRecord;
import com.lib.bookbrain.utils.Json;
import com.lib.bookbrain.utils.Parse;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * aop 运行前后的操作
 *
 * @author yunxia
 */
@Component
@Aspect
@AllArgsConstructor
public class AroundOperation {
/**
 * 日志服务
 */
private final LogMapper logMapper;

private final TokenAccessRecordMapper tokenMapper;

private final SimpleThreadContext<TokenBody> threadContext;

/**
 * 记录查询
 *
 * @param point 方法代理对象
 * @return 方法的返回值（代理对象执行）
 * @throws Throwable 方法执行可能会出现异常，需要标记抛出
 */
@Around("@annotation(com.lib.bookbrain.anno.AroundGet)")
public Object logGet(ProceedingJoinPoint point) throws Throwable {
   return log(point, this::fillBeforeGet, this::fillAfter);    // 日志
}

private void fillBeforeGet(Log log, Signature signature, Payload<BaseEntity> payload) {
   fillBefore(log, signature, payload);      // 填充日志
   log.fillType(LogType.R);                  // 设置日志类型
}

/**
 * 记录更新
 *
 * @param point 方法代理对象
 * @return 方法的返回值（代理对象执行）
 * @throws Throwable 方法执行的异常
 */
@Around("@annotation(com.lib.bookbrain.anno.AroundUpdate)")
public Object logUpdate(ProceedingJoinPoint point) throws Throwable {
   return log(point, this::fillBeforeUpdate, this::fillAfter); // 日志
}

private void fillBeforeUpdate(Log log, Signature signature, Payload<BaseEntity> payload) {
   fillBefore(log, signature, payload);      // 填充日志
   log.fillType(LogType.U);                  // 设置日志类型
}

@Around("@annotation(com.lib.bookbrain.anno.AroundDelete)")
public Object logDelete(ProceedingJoinPoint point) throws Throwable {
   return log(point, this::fillBeforeDelete, this::fillAfter); // 日志
}

private void fillBeforeDelete(Log log, Signature signature, Payload<BaseEntity> payload) {
   fillBefore(log, signature, payload);   // 填充日志
   log.fillType(LogType.D);               // 设置日志类型
}

/**
 * 将 token 封装到 parameter 里面去
 *
 * @param point service-method
 */
@Around("@within(com.lib.bookbrain.anno.AroundConduct)")
public Object aroundConduct(ProceedingJoinPoint point) throws Throwable {
   Object[] args = point.getArgs();                                  // 预期参数为 { payload, token(, id)? }
   Payload<BaseEntity> _payload = Payload.parseArgsTo(args);         // 解析参数
   logTokenUsed(threadContext.get(), (String) point.getArgs()[1]);   //
   args[0] = _payload;                                               // 参数写回
   return point.proceed(args);                                       // 使用新参数运行
}

/**
 * 日志基础记录
 *
 * @param point  service-method
 * @param before 运行前 执行操作
 * @param after  运行后 执行操作
 * @return 运行结果
 * @throws Throwable 执行可能的操作
 */
private Object log(ProceedingJoinPoint point, TriConsumer<Log, Signature, Payload<BaseEntity>> before, TriConsumer<Log, Long, Object> after) throws Throwable {
   
   /* ===================== 前 ===================== */
   Payload<BaseEntity> _payload = Payload.getOrNew(point.getArgs()[0]); // 解析参数
   // logTokenUsed(_payload.getTokenBody());                               // 记录 token 使用
   Log _log = Log.generate();                                           // 创建日志
   before.accept(_log, point.getSignature(), _payload);                 // 填充日志
   logMapper.create(_log);                                              // 插入日志
   
   /* ===================== 运行 ===================== */
   long _startTime = System.currentTimeMillis();                        // 运行起始时间
   Object _res = point.proceed();                                       // 运行
   
   /* ===================== 后 ===================== */
   long _endTime = System.currentTimeMillis();                          // 运行结束时间
   long _time = _endTime - _startTime;                                  // 运行耗时（毫秒值）
   after.accept(_log, _time, _res);                                     // 填充日志
   logMapper.alter(_log);                                               // 更新日志
   
   return _res;
}

/**
 * 执行前填充日志
 *
 * @param log       需要填充的日志对象
 * @param signature 用于生成日志信息的 signature
 * @param payload   用于生成日志信息的 payload
 */
private void fillBefore(Log log, Signature signature, Payload<BaseEntity> payload) {
   log.fillServiceName(generateServiceName(signature))      // 服务名
         .fillDataId(payload.getId())                       // 对应的数据 id（可能为 null）
         .fillInput(Json.stringify(payload))                // 序列化：请求的参数载体
         .fillCreatedBy(threadContext.get().getId());       // 操作人
}

/**
 * 执行后填充日志
 *
 * @param log  需要填充的日志对象
 * @param time 用于生成日志信息：执行耗时
 * @param res  用户生成日志信息：操作影响到的数据，或者查询到的结果
 */
private void fillAfter(Log log, Long time, Object res) {
   log.fillElapsedTime(time)                       // 执行耗时
         .fillOutput(Json.stringify(res));         // 序列化：操作数据
}

private void logTokenUsed(TokenBody body, String token) {
   TokenUsedRecord tur =
         TokenUsedRecord.builder()
               .userId(body.getId())
               .token(token)
               .build();
   tokenMapper.insert(tur);
}

/**
 * 生成服务名（数据类名称 + 方法名）
 *
 * @param signature 1
 * @return dataClass.method
 */
private String generateServiceName(Signature signature) {
   String serviceFullName = signature.getDeclaringType().getName();  // 获取服务全限定名 => ..xxxServiceImpl
   String serviceName = Parse.serviceToDataClass(serviceFullName);   // 提取服务数据类名 => xxx
   String method = signature.getName();                              // 获取方法名
   return String.format("%s.%s", serviceName, method);               // 格式化并返回
}

}