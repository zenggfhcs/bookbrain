package com.lib.bookbrain.aop;

import com.lib.bookbrain.model.*;
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

@Component
@Aspect
public class AroundOperation {
private final GetLogService getLogService;
private final UpdateLogService updateLogService;
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
@Around("@annotation(com.lib.bookbrain.anno.AroundGet)")
public Object logGet(ProceedingJoinPoint point) throws Throwable {
   /* -------- 前 -------- */
   // 解析参数
   Object[] args = point.getArgs();
   Payload<BaseEntity> _payload = getOrNew(args[0]);
   
   GetLog _getLog = GetLog.create();
   {
      // 执行的方法所在的类（接口）
      _getLog.setClassName(point.getSignature().getDeclaringType().getName());
      // 执行的方法
      _getLog.setMethod(point.getSignature().getName());
      // 方法接收的参数
      _getLog.setPayload(Json.stringify(_payload));
      // 返回值
      _getLog.setReturnValue("");
      // 运行时长
      _getLog.setElapsedTime(0L);
      // 方法执行者
      _getLog.setCreateBy(_payload.getTokenBody().getId());
   }
   // 插入日志，无论调用是否成功都有日志
   getLogService.createLog(_getLog);
   /* -------- 前 -------- */
   
   // 执行起始时间
   long _startTime = System.currentTimeMillis();
   
   Object _res = null;
   try {
      // 执行原始方法
      _res = point.proceed();
   } catch (Exception e) {
      _res = e.getMessage();
      throw e;
   } finally {
      /* -------- 后 -------- */
      // 执行结束时间
      long _endTime = System.currentTimeMillis();
      {
         // 返回值
         _getLog.setReturnValue(Json.stringify(_res));
         // 运行时间
         _getLog.setElapsedTime(_endTime - _startTime);
      }
      getLogService.updateLog(_getLog);
      /* -------- 后 -------- */
   }
   return _res;
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
   /* -------- 前 -------- */
   // 解析参数 => parameter
   Object[] args = point.getArgs();
   Payload<BaseEntity> _payload = getOrNew(args[0]);
   UpdatedLog _updatedLog = new UpdatedLog();
   {
      _updatedLog.setDataClass(Parse.serviceToDataClass(point.getSignature().getDeclaringType().getName()));
      _updatedLog.setDataId(_payload.getId());
      _updatedLog.setOldData("");
      _updatedLog.setNewData(Json.stringify(_payload));
      _updatedLog.setElapsedTime(0L);
      _updatedLog.setCreateBy(_payload.getTokenBody().getId());
      // 插入日志
      updateLogService.createLog(_updatedLog);
   }
   
   /* -------- 前 -------- */
   Object _res;
   Long _startTime = System.currentTimeMillis();
   try {
      _res = point.proceed();
   } finally {
      /* -------- 后 -------- */
      Long _endTime = System.currentTimeMillis();
      {
         _updatedLog.setElapsedTime(_endTime - _startTime);
         _payload.setTokenBody(null);
         _updatedLog.setOldData(Json.stringify(_payload));
         // 更新日志
         updateLogService.updateLog(_updatedLog);
      }
      /* -------- 后 -------- */
   }
   return _res;
}

@Around("@annotation(com.lib.bookbrain.anno.AroundDelete)")
public Object logDelete(ProceedingJoinPoint point) throws Throwable {
   /* -------- 前 -------- */
   // 解析参数 => parameter
   Object[] args = point.getArgs();
   Payload<BaseEntity> _payload = getOrNew(args[0]);
   DeletedLog _deletedLog = new DeletedLog();
   {
      _deletedLog.setDataClass(Parse.serviceToDataClass(point.getSignature().getDeclaringType().getName()));
      _deletedLog.setDataId(_payload.getId());
      _deletedLog.setData("");
      _deletedLog.setElapsedTime(0L);
      _deletedLog.setCreateBy(_payload.getTokenBody().getId());
      // 插入日志
      deleteLogService.createLog(_deletedLog);
   }
   
   /* -------- 前 -------- */
   Object _res;
   Long _startTime = System.currentTimeMillis();
   try {
      _res = point.proceed();
   } finally {
      /* -------- 后 -------- */
      Long _endTime = System.currentTimeMillis();
      {
         _deletedLog.setElapsedTime(_endTime - _startTime);
         _payload.setTokenBody(null);
         _payload.setId(null);
         _deletedLog.setData(Json.stringify(_payload));
         // 更新日志
         deleteLogService.updateLog(_deletedLog);
      }
      /* -------- 后 -------- */
   }
   return _res;
}

/**
 * 将 token 封装到 parameter 里面去
 *
 * @param point service-method
 */
@Around("@within(com.lib.bookbrain.anno.AroundConduct)")
public Object aroundConduct(ProceedingJoinPoint point) throws Throwable {
   // 预期参数为 { parameter, token, id }
   Object[] args = point.getArgs();
   Payload<BaseEntity> _payload = argsToParameter(args);
   args[0] = _payload;
   return point.proceed(args);
}


private Payload<BaseEntity> argsToParameter(Object[] args) {
   // 解析参数 => parameter
   Payload<BaseEntity> _payload = getOrNew(args[0]);
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

private Payload<BaseEntity> getOrNew(Object arg) {
   if (arg instanceof Payload<? extends BaseEntity>) {
      return (Payload<BaseEntity>) arg;
   }
   return new Payload<>();
}
}