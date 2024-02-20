package com.lib.bookbrain.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.lib.bookbrain.utils.MyFile;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Objects;

public class MyAlgorithm {
public static final String rsaPubKeyFileName = "jwt-rsa-pub.key";
public static final Algorithm HMAC;
public static final Algorithm RSA;
private static final String hmacKeyFileName = "jwt-hmac.key";
private static final String rsaPriKeyFileName = "jwt-rsa-pri.key";

static {
   HMAC = Algorithm.HMAC256(Objects.requireNonNull(MyFile.read(hmacKeyFileName)));
   
   RSAPublicKey publicKey = (RSAPublicKey) RSAKeyGenerator.getPublicKeyByPath(rsaPubKeyFileName);
   RSAPrivateKey privateKey = (RSAPrivateKey) RSAKeyGenerator.getPrivateKeyByPath(rsaPriKeyFileName);
   RSA = Algorithm.RSA256(publicKey, privateKey);
}
}
