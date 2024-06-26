package com.lib.bookbrain.aop;

import com.lib.bookbrain.anno.AroundLog;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.LogMapper;
import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.utils.Json;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
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
public class LogCURD {

/**
 * 日志数据操作
 */
private final LogMapper logMapper;

/**
 * tokenBody 线程局部变量
 */
private final SimpleThreadContext<TokenInfo> threadContext;

@Around("@annotation(aroundLog)")
public Object log(ProceedingJoinPoint point, AroundLog aroundLog) throws Throwable {/*
		预计参数 [payload]
	 */
	/* ===================== 前 ===================== */
	Log _log = Log.create();
	{
		_log.setServiceName(aroundLog.value());
		_log.setInput(Json.stringify(point.getArgs()));
		User _operator = new User();
		_operator.setId(threadContext.get().getAud());
		_log.setCreatedBy(_operator);
		_log.setType(aroundLog.type());
	}
	logMapper.create(_log);

	/* ===================== 运行 ===================== */
	long _startTime = System.currentTimeMillis();
	Object _res = point.proceed();

	/* ===================== 后 ===================== */
	{
		long _endTime = System.currentTimeMillis();
		long _time = _endTime - _startTime;
		_log.setElapsedTime(_time);
		_log.setOutput(Json.stringify(_res));
	}
	logMapper.alter(_log);

	return _res;
}


//@Around("@annotation(com.lib.bookbrain.anno.AroundAdd)")
//public Object logAdd(ProceedingJoinPoint point) throws Throwable {
//	return log(point, LogType.C);
//}

///**
// * 记录查询
// *
// * @param point 方法代理对象
// * @return 方法的返回值（代理对象执行）
// * @throws Throwable 方法执行可能会出现异常，需要标记抛出
// */
//@Around("@annotation(com.lib.bookbrain.anno.AroundGet)")
//public Object logGet(ProceedingJoinPoint point) throws Throwable {
//	return log(point, LogType.R);
//}

///**
// * 记录更新
// *
// * @param point 方法代理对象
// * @return 方法的返回值（代理对象执行）
// * @throws Throwable 方法执行的异常
// */
//@Around("@annotation(com.lib.bookbrain.anno.AroundUpdate)")
//public Object logUpdate(ProceedingJoinPoint point) throws Throwable {
//	return log(point, LogType.U);
//}
//
//@Around("@annotation(com.lib.bookbrain.anno.AroundDelete)")
//public Object logDelete(ProceedingJoinPoint point) throws Throwable {
//	return log(point, LogType.D);
//}
//
///**
// * 日志基础记录
// *
// * @param point service-method
// * @return 运行结果
// * @throws Throwable 执行可能的操作
// */
//private Object log(ProceedingJoinPoint point, LogType logType) throws Throwable {
//	/*
//		预计参数 [payload]
//	 */
//	/* ===================== 前 ===================== */
//	Payload<Entity> _p = Payload.getOrNew(point.getArgs()[0]);
//	Log _log = Log.create();
//	{
//		_log.setServiceName(generateServiceName(point.getSignature()));
//		_log.setInput(Json.stringify(_p));
//		User _operator = new User();
//		_operator.setId(threadContext.get().getAud());
//		_log.setCreatedBy(_operator);
//		_log.setType(logType.getValue());
//	}
//	logMapper.create(_log);
//
//	/* ===================== 运行 ===================== */
//	long _startTime = System.currentTimeMillis();
//	Object _res = point.proceed();
//
//	/* ===================== 后 ===================== */
//	{
//		long _endTime = System.currentTimeMillis();
//		long _time = _endTime - _startTime;
//		_log.setElapsedTime(_time);
//		_log.setOutput(Json.stringify(_res));
//	}
//	logMapper.alter(_log);
//
//	return _res;
//}
//
///**
// * 生成服务名（数据类名称）
// *
// * @param signature 1
// * @return dataClass.method
// */
//private String generateServiceName(Signature signature) {
//	String serviceFullName = signature.getDeclaringType().getName();
//	return Parse.serviceToDataClass(serviceFullName);
//}

}
