package com.lib.bookbrain.security;

import com.lib.bookbrain.utils.MyFile;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author springdoc.cn
 * 生成 RSA 密钥对
 */

public class RSAKeyGenerator {

public static PublicKey getPublicKeyPyStringKey(String key) {
	byte[] publicKeyBytes = Base64.getMimeDecoder().decode(key);
	X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);

	try {
		return KeyFactory.getInstance("RSA").generatePublic(keySpec);
	} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
		throw new RuntimeException(e);
	}
}

public static PublicKey getPublicKeyByPath(String path) {
	String publicKeyString = MyFile.read(path);
	return getPublicKeyPyStringKey(publicKeyString);
}

public static PrivateKey getPrivateKeyByKeyString(String key) {
	byte[] privateKeyBytes = Base64.getMimeDecoder().decode(key);
	PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);

	try {
		return KeyFactory.getInstance("RSA").generatePrivate(keySpec);
	} catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
		throw new RuntimeException(e);
	}
}

public static PrivateKey getPrivateKeyByPath(String path) {
	String privateKeyString = MyFile.read(path);
	return getPrivateKeyByKeyString(privateKeyString);
}

public static void main(String[] args) throws NoSuchAlgorithmException {
	generate();
}


public static void generate() throws NoSuchAlgorithmException {
	// 初始化 Key 生成器，指定算法类型为 RSA
	KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

	// 密钥长度为 2048 位
	keyPairGenerator.initialize(2048);

	// 生成密钥对
	KeyPair keyPair = keyPairGenerator.generateKeyPair();

	// 获取公钥
	RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();

	// 获取私钥
	RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

	System.out.println("公钥：" + Base64.getMimeEncoder().encodeToString(rsaPublicKey.getEncoded()));

	System.out.println("私钥：" + Base64.getMimeEncoder().encodeToString(rsaPrivateKey.getEncoded()));

}
}
