package com.lib.bookbrain.aop;

import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.TokenAccessRecordMapper;
import com.lib.bookbrain.model.comm.TokenInfo;
import com.lib.bookbrain.model.entity.TokenUsedRecord;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@AllArgsConstructor
public class LogTokenUsed {

/**
 * token 数据操作
 */
private final TokenAccessRecordMapper tokenMapper;

/**
 * tokenBody 线程局部变量
 */
private final SimpleThreadContext<TokenInfo> threadContext;

/**
 * 将 token 封装到 payload 里面去
 *
 * @param point service-method
 */
@Around("@within(com.lib.bookbrain.anno.AroundConduct)")
public Object aroundConduct(ProceedingJoinPoint point) throws Throwable {
	logTokenUsed(threadContext.get(), (String) point.getArgs()[1]);
	return point.proceed(point.getArgs());
}

/**
 * 记录 token 使用
 *
 * @param info  body
 * @param token token
 */
private void logTokenUsed(TokenInfo info, String token) {
	TokenUsedRecord tur = TokenUsedRecord.builder()
			.userId(info.getAud())
			.token(token)
			.build();
	tokenMapper.insert(tur);
}
}
