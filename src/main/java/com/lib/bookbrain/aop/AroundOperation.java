package com.lib.bookbrain.aop;

import com.lib.bookbrain.constants.LogType;
import com.lib.bookbrain.dao.LogMapper;
import com.lib.bookbrain.exception.Assert;
import com.lib.bookbrain.exception.PayloadMissException;
import com.lib.bookbrain.fnuction.TriConsumer;
import com.lib.bookbrain.model.BaseEntity;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.utils.Json;
import com.lib.bookbrain.utils.Parse;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 运行前后的操作
 *
 * @author yunxia
 */
@Component
@Aspect
@AllArgsConstructor
public class AroundOperation {
/**
 * 日志
 */
private final LogMapper logMapper;

/**
 * 记录查询
 *
 * @param point 方法代理对象
 * @return 方法的返回值（代理对象执行）
 * @throws Throwable 方法执行的异常
 */
@Around("@annotation(com.lib.bookbrain.annotation.AroundGet)")
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
@Around("@annotation(com.lib.bookbrain.annotation.AroundUpdate)")
public Object logUpdate(ProceedingJoinPoint point) throws Throwable {
   return log(point, this::fillBeforeUpdate, this::fillAfter); // 日志
}

private void fillBeforeUpdate(Log log, Signature signature, Payload<BaseEntity> payload) {
   fillBefore(log, signature, payload);      // 填充日志
   log.fillType(LogType.U);                  // 设置日志类型
}

@Around("@annotation(com.lib.bookbrain.annotation.AroundDelete)")
public Object logDelete(ProceedingJoinPoint point) throws Throwable {
   return log(point, this::fillBeforeDelete, this::fillAfter); // 日志
}

private void fillBeforeDelete(Log log, Signature signature, Payload<BaseEntity> payload) {
   fillBefore(log, signature, payload);      // 填充日志
   log.fillType(LogType.D);                  // 设置日志类型
}

/**
 * 将 token 封装到 parameter 里面去
 *
 * @param point service-method
 */
@Around("@within(com.lib.bookbrain.annotation.AroundConduct)")
public Object aroundConduct(ProceedingJoinPoint point) throws Throwable {
   Object[] args = point.getArgs();                            // 预期参数为 { payload, token(, id)? }
   Payload<BaseEntity> _payload = Payload.parseArgsTo(args);   // 解析参数
   args[0] = _payload;                                         // 参数写回
   return point.proceed(args);                                 // 使用新参数运行
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
   Assert.isCorrect(() -> point.getArgs().length > 0                    // 断言
         , new PayloadMissException());                                 // 断言失败将会抛出的异常
   Payload<BaseEntity> _payload = Payload.getOrNew(point.getArgs()[0]); // 解析参数
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

private void fillBefore(Log log, Signature signature, Payload<BaseEntity> payload) {
   log.fillServiceName(generateServiceName(signature))      // 1
         .fillDataId(payload.getId())                       // 2
         .fillInput(Json.stringify(payload))                // 3
         .fillCreatedBy(payload.getTokenBody().getId());    // 4
}

private void fillAfter(Log log, Long time, Object res) {
   log.fillElapsedTime(time)                       // 5
         .fillOutput(Json.stringify(res));         // 6
}

/**
 * 生成服务名（数据类名称 + 方法名）
 *
 * @param signature 1
 * @return dataClass.method
 */
private String generateServiceName(Signature signature) {
   String serviceFullName = signature.getDeclaringType().getName();     // 获取服务全限定名
   String serviceName = Parse.serviceToDataClass(serviceFullName);      // 提取服务数据类名
   String method = signature.getName();                                 // 获取方法名
   return String.format("%s.%s", serviceName, method);                  // 格式化并返回
// Parse.serviceToDataClass(signature.getDeclaringType().getName()) + signature.getName()
}
}