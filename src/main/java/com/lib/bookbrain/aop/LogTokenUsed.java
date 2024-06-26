package com.lib.bookbrain.aop;

import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.TokenAccessRecordMapper;
import com.lib.bookbrain.model.entity.TokenAccessRecord;
import com.lib.bookbrain.model.pojo.TokenInfo;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author yunxia
 */
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
 * 记录 token 的使用
 *
 * @param point service-method
 */
//@Around("@within(com.lib.bookbrain.anno.AroundConduct)")
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
	TokenAccessRecord tur = TokenAccessRecord.builder()
			.userId(info.getAud())
			.token(token)
			.build();
	tokenMapper.insert(tur);
}
}
