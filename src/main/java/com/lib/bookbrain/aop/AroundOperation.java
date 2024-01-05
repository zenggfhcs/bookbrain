package com.lib.bookbrain.aop;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.TokenBody;
import com.lib.bookbrain.model.entity.BaseEntity;
import com.lib.bookbrain.model.log.DeletedLog;
import com.lib.bookbrain.model.log.GetLog;
import com.lib.bookbrain.model.log.UpdatedLog;
import com.lib.bookbrain.service.DeleteLogService;
import com.lib.bookbrain.service.GetLogService;
import com.lib.bookbrain.service.UpdateLogService;
import com.lib.bookbrain.utils.Json;
import com.lib.bookbrain.utils.Jwt;
import com.lib.bookbrain.utils.Parse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 运行前后的操作
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
   /* -------- 前 -------- */
   Payload<BaseEntity> _payload = Payload.getOrNew(point.getArgs()[0]);// 解析参数
   GetLog _getLog = GetLog.create();// 创建日志
   this.fillBeforeGet(point, _payload, _getLog);// 填充日志信息
   getLogService.createLog(_getLog);// 插入日志，无论调用是否成功都有日志
   /* -------- 前 -------- */
   long _startTime = System.currentTimeMillis();// 执行起始时间
   
   Object _res = null;
   try {
      _res = point.proceed();// 执行原始方法
   } catch (Exception e) {
      _res = e.getMessage();
      throw e;
   } finally {
      /* -------- 后 -------- */
      long _endTime = System.currentTimeMillis();// 执行结束时间
      this.fillAfterGet(_res, _endTime - _startTime, _getLog);// 填充日志信息
      getLogService.updateLogAfterReturn(_getLog);// 将执行完成的返回值更新到日志
      /* -------- 后 -------- */
   }
   return _res;
}

private void fillBeforeGet(ProceedingJoinPoint point, Payload<BaseEntity> payload, GetLog log) {
   // 执行的方法所在的类（接口）
   log.setClassName(point.getSignature().getDeclaringType().getName());
   // 执行的方法
   log.setMethod(point.getSignature().getName());
   // 方法接收的参数
   log.setPayload(Json.stringify(payload));
   // 返回值
   log.setReturnValue("");
   // 运行时长
   log.setElapsedTime(0L);
   // 方法执行者
   log.setCreateBy(payload.getTokenBody().getId());
}

private void fillAfterGet(Object res, Long time, GetLog log) {
   // 返回值
   log.setReturnValue(Json.stringify(res));
   // 运行时间
   log.setElapsedTime(time);
   
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
   /* -------- 前 -------- */
   Payload<BaseEntity> _payload = Payload.getOrNew(point.getArgs()[0]);// 解析参数 => parameter
   UpdatedLog _updatedLog = new UpdatedLog();
   this.fillBeforeUpdate(point, _payload, _updatedLog);
   updateLogService.createLog(_updatedLog);// 插入日志
   /* -------- 前 -------- */
   
   Object _res;
   Long _startTime = System.currentTimeMillis();
   try {
      _res = point.proceed();
   } finally {
      /* -------- 后 -------- */
      Long _endTime = System.currentTimeMillis();
      this.fillAfterUpdate(_payload, _endTime - _startTime, _updatedLog);
      // 更新日志
      updateLogService.updateLog(_updatedLog);
      /* -------- 后 -------- */
   }
   return _res;
}

private void fillBeforeUpdate(ProceedingJoinPoint point, Payload<BaseEntity> payload, UpdatedLog log) {
   // 通过服务名称，解析出实体名称
   log.setDataClass(Parse.serviceToDataClass(point.getSignature().getDeclaringType().getName()));
   log.setDataId(payload.getId());
   log.setOldData("");
   log.setNewData(Json.stringify(payload));
   log.setElapsedTime(0L);
   log.setCreateBy(payload.getTokenBody().getId());
}

private void fillAfterUpdate(Payload<BaseEntity> payload, Long time, UpdatedLog log) {
   log.setElapsedTime(time);
   payload.setTokenBody(null);
   log.setOldData(Json.stringify(payload.getEntity()));
}

@Around("@annotation(com.lib.bookbrain.annotation.AroundDelete)")
public Object logDelete(ProceedingJoinPoint point) throws Throwable {
   /* -------- 前 -------- */
   // 解析参数 => parameter
   Payload<BaseEntity> _payload = Payload.getOrNew(point.getArgs()[0]);
   DeletedLog _deletedLog = new DeletedLog();
   this.fillBeforeDelete(point, _payload, _deletedLog);
   deleteLogService.createLog(_deletedLog);// 插入日志
   /* -------- 前 -------- */
   Object _res;
   Long _startTime = System.currentTimeMillis();
   try {
      _res = point.proceed();
   } finally {
      /* -------- 后 -------- */
      Long _endTime = System.currentTimeMillis();
      {
         this.fillAfterDelete(_payload, _endTime - _startTime, _deletedLog);
         deleteLogService.updateLog(_deletedLog); // 更新日志
      }
      /* -------- 后 -------- */
   }
   return _res;
}

private void fillBeforeDelete(ProceedingJoinPoint point, Payload<BaseEntity> payload, DeletedLog log) {
   log.setDataClass(Parse.serviceToDataClass(point.getSignature().getDeclaringType().getName()));
   log.setDataId(payload.getId());
   log.setData("");
   log.setElapsedTime(0L);
   log.setCreateBy(payload.getTokenBody().getId());
}

private void fillAfterDelete(Payload<BaseEntity> payload, Long time, DeletedLog log) {
   log.setElapsedTime(time);
   payload.setTokenBody(null);
   payload.setId(null);
   log.setData(Json.stringify(payload));
}

/**
 * 将 token 封装到 parameter 里面去
 *
 * @param point service-method
 */
@Around("@within(com.lib.bookbrain.annotation.AroundConduct)")
public Object aroundConduct(ProceedingJoinPoint point) throws Throwable {
   // 预期参数为 { parameter, token, id }
   Object[] args = point.getArgs();
   Payload<BaseEntity> _payload = argsToParameter(args);
   args[0] = _payload;
   return point.proceed(args);
}


private Payload<BaseEntity> argsToParameter(Object[] args) {
   // 解析参数 => parameter
   Payload<BaseEntity> _payload = Payload.getOrNew(args[0]);
   // token
   String token = args[1].toString();
   // token => tokenBody
   TokenBody tokenBody = Jwt.decodeToken(token);
   _payload.setTokenBody(tokenBody);
   if (args.length == 3 && args[2].getClass() == Integer.class) {
      _payload.setId(Integer.parseInt(args[2].toString()));
   }
   return _payload;
}
@FunctionalInterface
public interface Operation<T, U, R> {
   R exec(T t, U u);
}
}