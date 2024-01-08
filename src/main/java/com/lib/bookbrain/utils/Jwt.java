package com.lib.bookbrain.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lib.bookbrain.model.TokenBody;
import com.lib.bookbrain.model.entity.User;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

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
/**
 * key
 */
private static final String key;
private static final Algorithm algorithm;

static {
   key = "b4e2eef5f381ca2db9eb9814073cdd8f39971663bc2bd20bc6287c4ef8cba43f";
}

static {
   algorithm = Algorithm.HMAC256(key);
}

static {
   EFFECTIVE_DURATION = 1_411_200_000;
}

/**
 * jwt 编码
 *
 * @param user 需要编码的用户公共数据
 * @return jwt token
 */
public static String encoder(User user) {
   return coder(user.getUserId(), user.getDisplayName(), user.getAuthority());
}

public static String encoder(TokenBody body) {
   return coder(body.getId(), body.getName(), body.getAuthority());
}

private static String coder(Integer id, String name, Integer authority) {
   return JWT.create()
         // 自定义信息
         .withClaim("id", id)
         .withClaim("name", name)
         .withClaim("authority", authority)
         // 有效时间
         .withExpiresAt(new Date(System.currentTimeMillis() + EFFECTIVE_DURATION))
         .sign(algorithm);
}

/**
 * jwt 解码
 *
 * @param token jwt token
 * @return 解码后的 TokenBody 对象
 */
public static TokenBody decoder(String token) {
   // 解析 jwt
   DecodedJWT deJwt = JWT.require(algorithm).build().verify(token);
   // 获取 payload 是 base64 形式
   String payload = deJwt.getPayload();
   // 解码为字节数组
   byte[] payloadBytes = Base64.getDecoder().decode(payload);
   // 将字节数组转换为字符串（使用UTF-8字符集）
   String data = new String(payloadBytes, StandardCharsets.UTF_8);
   return Json.parse(data, TokenBody.class);
}

public static void main(String[] args) {
   System.out.println((EFFECTIVE_DURATION / 3 * 7));
   User user = new User();
   user.setUserId(1);
   user.setDisplayName("admin");
   user.setAuthority(Integer.MAX_VALUE);
   System.out.println(encoder(user));
}
}
