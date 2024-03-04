package com.lib.bookbrain.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.lib.bookbrain.utils.MyFile;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Objects;

public class PreDefinedAlgorithm {
public static final Algorithm HMAC;
public static final Algorithm RSA;
public static final String rsaPubKeyFileName = "jwt-rsa-pub.key";
private static final String hmacKeyFileName = "jwt-hmac.key";
private static final String rsaPriKeyFileName = "jwt-rsa-pri.key";

public static RSAPublicKey publicKey = (RSAPublicKey) RSAKeyGenerator.getPublicKeyByPath(rsaPubKeyFileName);
public static RSAPrivateKey privateKey = (RSAPrivateKey) RSAKeyGenerator.getPrivateKeyByPath(rsaPriKeyFileName);

static {
	HMAC = Algorithm.HMAC256(Objects.requireNonNull(MyFile.read(hmacKeyFileName)));

	RSA = Algorithm.RSA256(publicKey, privateKey);
}
}
