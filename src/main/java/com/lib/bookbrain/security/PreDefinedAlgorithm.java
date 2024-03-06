package com.lib.bookbrain.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.lib.bookbrain.utils.MyFile;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Objects;

public class PreDefinedAlgorithm {

public static class KeyPath {
	static final String RSA_PUB_KEY = "jwt-rsa-pub.key";

	static final String HMAC_KEY = "jwt-hmac.key";

	static final String RSA_PRI_KEY = "jwt-rsa-pri.key";

}

public static class Key {
	public static String RSA_PUBLIC_KEY_STRING;

	public static String RSA_PRIVATE_KEY_STRING;

	public static RSAPublicKey RSA_PUBLIC_KEY;

	public static RSAPrivateKey RSA_PRIVATE_KEY;

	public static String HMAC_KEY;

	static {

		RSA_PUBLIC_KEY_STRING = MyFile.read(KeyPath.RSA_PUB_KEY);

		RSA_PRIVATE_KEY_STRING = MyFile.read(KeyPath.RSA_PRI_KEY);

		RSA_PUBLIC_KEY = (RSAPublicKey) RSAKeyGenerator.getPublicKeyPyStringKey(RSA_PUBLIC_KEY_STRING);

		RSA_PRIVATE_KEY = (RSAPrivateKey) RSAKeyGenerator.getPrivateKeyByKeyString(RSA_PRIVATE_KEY_STRING);

		HMAC_KEY = Objects.requireNonNull(MyFile.read(KeyPath.HMAC_KEY));
	}

}

public static final Algorithm HMAC;
public static final Algorithm RSA;

static {
	HMAC = Algorithm.HMAC256(Key.HMAC_KEY);

	RSA = Algorithm.RSA256(Key.RSA_PUBLIC_KEY, Key.RSA_PRIVATE_KEY);
}
}
