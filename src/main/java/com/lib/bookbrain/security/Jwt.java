package com.lib.bookbrain.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lib.bookbrain.model.comm.TokenInfo;
import com.lib.bookbrain.model.entity.User;
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
 * 有效时长 毫秒值 七天
 * 7 * 24 * 60 * 60 * 1000
 */
public static final long EFFECTIVE_DURATION;

static {
   EFFECTIVE_DURATION = 1_411_200_000;
}

/* ============================ encoder ============================ */
public static String encoder(User user, Algorithm algorithm) {
   return coder(user.getId(), algorithm);
}

private static String coder(Integer id, Algorithm algorithm) {
   return coder(id, System.currentTimeMillis(), algorithm);
}

private static String coder(Integer id, Long time, Algorithm algorithm) {
   return JWT.create()
         .withIssuer("sys")
         .withSubject("Valid")
         .withAudience(id.toString())
         .withNotBefore(new Date(culTime(time + EFFECTIVE_DURATION)))
         .withExpiresAt(new Date(culTime(time)))
         .withJWTId(UUID.randomUUID().toString())
         .sign(algorithm);
}

private static Long culTime(Long time) {
   return (time) * 1000;
}
/* ============================ encoder ============================ */


/* ============================ decoder ============================ */

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
         .verify(token);     // 解析 jwt
   
   String payload = deJwt.getPayload();                                 // 获取 payload 是 base64 形式
   
   byte[] payloadBytes = Base64.getDecoder().decode(payload);           // 解码为字节数组
   
   String data = new String(payloadBytes, StandardCharsets.UTF_8);      // 将字节数组转换为字符串（使用UTF-8字符集）
   
   return Json.parse(data, TokenInfo.class);
}
/* ============================ decoder ============================ */


public static void main(String[] args) {
   /* ------------------------ test ------------------------ */
   User user = new User();
   user.setId(1);
   System.out.println(encoder(user, PreDefinedAlgorithm.RSA));
}

}
