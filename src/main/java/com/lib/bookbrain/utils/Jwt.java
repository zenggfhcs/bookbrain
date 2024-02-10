package com.lib.bookbrain.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lib.bookbrain.model.dto.TokenBody;
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
   return coder(user.getId(), user.getDisplayName());
}

/**
 * 编码 jwt 实现
 *
 * @param id   编码 id
 * @param name 编码 name
 * @return token
 */
private static String coder(Integer id, String name) {
   return JWT.create()
         .withClaim("id", id)                                                 // id
         .withClaim("name", name)                                             // name
         .withExpiresAt(new Date(System.currentTimeMillis() + EFFECTIVE_DURATION))  // 有效时间
         .sign(algorithm);
}

/**
 * jwt 解码
 *
 * @param token jwt token
 * @return 解码后的 TokenBody 对象
 */
public static TokenBody decoder(String token) {
   DecodedJWT deJwt = JWT.require(algorithm).build().verify(token);     // 解析 jwt
   String payload = deJwt.getPayload();                                 // 获取 payload 是 base64 形式
   byte[] payloadBytes = Base64.getDecoder().decode(payload);           // 解码为字节数组
   String data = new String(payloadBytes, StandardCharsets.UTF_8);      // 将字节数组转换为字符串（使用UTF-8字符集）
   
   return Json.parse(data, TokenBody.class);
}

public static void main(String[] args) {
   /* ------------------------ test ------------------------ */
   User user = new User();
   user.setId(1);
   user.setDisplayName("admin");
   user.setAuthority(Long.MAX_VALUE);
   System.out.println(encoder(user));
}
}
