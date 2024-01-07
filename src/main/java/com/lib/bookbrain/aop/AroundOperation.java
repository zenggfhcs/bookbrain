package com.lib.bookbrain.aop;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.entity.BaseEntity;
import com.lib.bookbrain.model.log.DeletedLog;
import com.lib.bookbrain.model.log.GetLog;
import com.lib.bookbrain.model.log.UpdatedLog;
import com.lib.bookbrain.service.DeleteLogService;
import com.lib.bookbrain.service.GetLogService;
import com.lib.bookbrain.service.UpdateLogService;
import com.lib.bookbrain.utils.Json;
import com.lib.bookbrain.utils.Parse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 运行前后的操作
 *
 * @author yunxia
 */
@Component
@Aspect
public class AroundOperation {
/**
 * 读 日志服务
 */
private final GetLogService getLogService;
/**
 * 改 日志服务
 */
private final UpdateLogService updateLogService;
/**
 * 删 日志服务
 */
private final DeleteLogService deleteLogService;

@Autowired
public AroundOperation(GetLogService getLogService, UpdateLogService updateLogService, DeleteLogService deleteLogService) {
   this.getLogService = getLogService;
   this.updateLogService = updateLogService;
   this.deleteLogService = deleteLogService;
}

/**
 * 记录查询
 *
 * @param point 方法代理对象
 * @return 方法的返回值（代理对象执行）
 * @throws Throwable 方法执行的异常
 */
@Around("@annotation(com.lib.bookbrain.annotation.AroundGet)")
public Object logGet(ProceedingJoinPoint point) throws Throwable {
   /* ===================== 前 ===================== */
   Payload<BaseEntity> _payload = Payload.getOrNew(point.getArgs()[0]); // 解析参数
   GetLog _getLog = GetLog.create();                                    // 创建日志
   this.fillBeforeGet(point.getSignature(), _payload, _getLog);         // 填充日志信息
   
   /* ===================== 执行 ===================== */
   long _startTime = System.currentTimeMillis();                        // 记录执行起始时间
   Object _res = point.proceed();                                       // 执行原始方法
   
   /* ===================== 后 ===================== */
   long _endTime = System.currentTimeMillis();                          // 执行结束时间
   long _time = _endTime - _startTime;                                  // 执行耗时（毫秒值）
   this.fillAfterGet(_res, _time, _getLog);                             // 填充日志信息
   return _res;
}

private void fillBeforeGet(Signature signature, Payload<BaseEntity> payload, GetLog log) {
   log.setClassName(Parse.serviceToDataClass(signature.getDeclaringType().getName())); // 数据对象对应的类
   log.setMethod(signature.getName());                                                 // 执行的方法
   log.setPayload(Json.stringify(payload));                                            // 方法接收的参数
   log.setReturnValue("");                                                             // 返回值
   log.setElapsedTime(0L);                                                             // 运行时长
   log.setCreateBy(payload.getTokenBody().getId());                                    // 方法执行者
   getLogService.createLog(log);                                                       // 插入日志，无论调用是否成功都有日志
}

private void fillAfterGet(Object res, Long time, GetLog log) {
   log.setReturnValue(Json.stringify(res));  // 返回值
   log.setElapsedTime(time);                 // 运行时间
   getLogService.updateLogAfterReturn(log);  // 将执行完成的返回值更新到日志
}

/**
 * 记录更新
 *
 * @param point 方法代理对象
 * @return 方法的返回值（代理对象执行）
 * @throws Throwable 方法执行的 常
 */
@Around("@annotation(com.lib.bookbrain.annotation.AroundUpdate)")
public Object logUpdate(ProceedingJoinPoint point) throws Throwable {
   /* ===================== 前 ===================== */
   Payload<BaseEntity> _payload = Payload.getOrNew(point.getArgs()[0]); // 解析参数
   UpdatedLog _updatedLog = new UpdatedLog();                           // 创建日志
   this.fillBeforeUpdate(point.getSignature(), _payload, _updatedLog);  // 填充日志
   
   /* ===================== 运行 ===================== */
   long _startTime = System.currentTimeMillis();                        // 记录起始时间
   Object _res = point.proceed();                                       // 执行
   
   /* ===================== 后 ===================== */
   long _endTime = System.currentTimeMillis();                          // 执行结束时间
   long _time = _endTime - _startTime;                                  // 执行耗时（毫秒值）
   this.fillAfterUpdate(_payload, _time, _updatedLog);                  // 填充日志
   
   return _res;
}

private void fillBeforeUpdate(Signature signature, Payload<BaseEntity> payload, UpdatedLog log) {
   log.setDataClass(Parse.serviceToDataClass(signature.getDeclaringType().getName())); // 数据对象对应的类
   log.setDataId(payload.getId());                                                     // 数据 id
   log.setOldData("");                                                                 // 旧数据（JSON）
   log.setNewData(Json.stringify(payload));                                            // 新数据（JSON）
   log.setElapsedTime(0L);                                                             // 运行时间
   log.setCreateBy(payload.getTokenBody().getId());                                    // 动作执行者
   updateLogService.createLog(log);                                                    // 插入日志
}

private void fillAfterUpdate(Payload<BaseEntity> payload, Long time, UpdatedLog log) {
   log.setElapsedTime(time);                             // 运行时间
   payload.setTokenBody(null);                           // 去除 JSON 干扰
   log.setOldData(Json.stringify(payload.getEntity()));  // 旧数据
   updateLogService.updateLog(log);                      // 更新日志
}

@Around("@annotation(com.lib.bookbrain.annotation.AroundDelete)")
public Object logDelete(ProceedingJoinPoint point) throws Throwable {
   /* ===================== 前 ===================== */
   Payload<BaseEntity> _payload = Payload.getOrNew(point.getArgs()[0]); // 解析参数
   DeletedLog _deletedLog = new DeletedLog();                           // 创建日志
   this.fillBeforeDelete(point.getSignature(), _payload, _deletedLog);  // 填充日志
   
   /* ===================== 运行 ===================== */
   long _startTime = System.currentTimeMillis();                        // 运行起始时间
   Object _res = point.proceed();                                       // 运行
   
   /* ===================== 后 ===================== */
   long _endTime = System.currentTimeMillis();                          // 运行结束时间
   long _time = _endTime - _startTime;                                  // 运行耗时（毫秒值）
   this.fillAfterDelete(_payload, _time, _deletedLog);                  // 填充日志
   
   return _res;
}

private void fillBeforeDelete(Signature signature, Payload<BaseEntity> payload, DeletedLog log) {
   log.setDataClass(Parse.serviceToDataClass(signature.getDeclaringType().getName())); // 数据对象对应的类
   log.setDataId(payload.getId());                                                     // 数据 id
   log.setData("");                                                                    // 数据初始为空
   log.setElapsedTime(0L);                                                             // 运行时间初始为 0
   log.setCreateBy(payload.getTokenBody().getId());                                    // 执行者
   deleteLogService.createLog(log);                                                    // 插入日志
}

private void fillAfterDelete(Payload<BaseEntity> payload, Long time, DeletedLog log) {
   log.setElapsedTime(time);              // 更新运行时间
   payload.setTokenBody(null);            // 去除 JSON 干扰
   payload.setId(null);                   // 去除 JSON 干扰
   log.setData(Json.stringify(payload));  // 更新数据
   deleteLogService.updateLog(log);       // 更新日志
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
}