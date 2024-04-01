package com.lib.bookbrain.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.utils.Json;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * jwt token 处理器
 *
 * @author yunxia
 */
public class Jwt {

/**
 * 有效时长 秒值
 */
public static final long EFFECTIVE_DURATION;

static {
	EFFECTIVE_DURATION = 7 * 24 * 60 * 60 * 1000;
}

//#region encoder
/* === === === === === === === === === === === === ===  === === === === === === === === === === === === === */
public static String encoder(Integer id, long time) {
	return coder(id, time, PreDefinedAlgorithm.HMAC);
}

private static String coder(int id, Algorithm algorithm) {
	return coder(id, System.currentTimeMillis(), algorithm);
}

private static String coder(int id, long time, Algorithm algorithm) {
	long _currentTimeMillis = System.currentTimeMillis();
	return JWT.create()
			.withIssuer("sys")
			.withSubject("valid")
			.withAudience(String.valueOf(id))
			.withNotBefore(new Date(_currentTimeMillis))
			.withExpiresAt(new Date(time + _currentTimeMillis))
			.withJWTId(UUID.randomUUID().toString())
			.sign(algorithm);
}
/* === === === === === === === === === === === === ===  === === === === === === === === === === === === === */
//#endregion

//#region decoder
/* === === === === === === === === === === === === ===  === === === === === === === === === === === === === */

/**
 * jwt 解码
 *
 * @param token jwt token
 * @return 解码后的 TokenBody 对象
 */
public static TokenInfo decoder(String token) {
	return decoder(token, PreDefinedAlgorithm.HMAC);
}

public static TokenInfo decoder(String token, Algorithm algorithm) {
	DecodedJWT deJwt = JWT.require(algorithm)
			.build()
			.verify(token); // 解析 jwt

	String payload = deJwt.getPayload(); // 获取 payload 是 base64 形式

	byte[] payloadBytes = Base64.getDecoder().decode(payload); // 解码为字节数组

	String data = new String(payloadBytes, StandardCharsets.UTF_8); // 将字节数组转换为字符串（使用UTF-8字符集）

	return Json.parse(data, TokenInfo.class);
}
/* === === === === === === === === === === === === ===  === === === === === === === === === === === === === */
//#endregion

public static void main(String[] args) {
	/* ------------------------ test ------------------------ */

	String token = encoder(1, 0L);
	System.out.println(token);
//
//	TokenInfo info = decoder(token);
//
//	System.out.println(info.getNbf());
//	System.out.println(info.getExp());
}

}
