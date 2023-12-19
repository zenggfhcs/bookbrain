package com.lib.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lib.model.TokenBody;
import com.lib.model.User;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

public class Jwt {
/**
 * key
 */
private static final String key;
private static final Algorithm algorithm;
/**
 * 有效时长 毫秒值 三天
 * 3 * 24 * 60 * 60 * 1000
 */
private static final long EFFECTIVE_DURATION;

static {
   key = "b4e2eef5f381ca2db9eb9814073cdd8f39971663bc2bd20bc6287c4ef8cba43f";
}

static {
   algorithm = Algorithm.HMAC256(key);
}

static {
   EFFECTIVE_DURATION = 604_800_000;
}

/**
 * jwt 编码
 *
 * @param user 需要编码的用户公共数据
 * @return jwt token
 */
public static String createToken(User user) {
   try {
      return JWT.create()
            // 自定义信息
            .withClaim("id", user.getUserId())
            .withClaim("name", user.getDisplayName())
            .withClaim("authority", user.getAuthority())
            // 有效时间
            .withExpiresAt(new Date(System.currentTimeMillis() + EFFECTIVE_DURATION))
            .sign(algorithm);
   } catch (JWTCreationException exception) {
      throw new JWTCreationException(exception.getMessage(), null);
   }
}

/**
 * jwt 解码
 *
 * @param token jwt token
 * @return 解码后的 TokenBody 对象
 */
public static TokenBody decodeToken(String token) {
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
   User user = new User();
   user.setUserId(1);
   user.setDisplayName("admin");
   user.setAuthority(Integer.MAX_VALUE);
   System.out.println(createToken(user));
}
}
