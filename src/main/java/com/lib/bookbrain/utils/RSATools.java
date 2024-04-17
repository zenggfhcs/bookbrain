package com.lib.bookbrain.utils;

import com.lib.bookbrain.exception.DataStructureException;
import com.lib.bookbrain.security.PreDefinedAlgorithm;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class RSATools {
private static String decrypt(byte[] data) {
	return CryptoHandler.decrypt(Base64.getDecoder().decode(data), PreDefinedAlgorithm.Key.RSA_PRIVATE_KEY);
}

public static String decrypt(String dataString) {
	return decrypt(Base64.getDecoder().decode(dataString.getBytes(StandardCharsets.UTF_8)));
}


// 使用公钥加密数据
public static String encrypt(String data) {
	return CryptoHandler.encrypt(data, PreDefinedAlgorithm.Key.RSA_PUBLIC_KEY);
}

/**
 * 相反的加密
 */
public static class Reverse {
	/**
	 * 使用私钥加密
	 */
	public static String encrypt(String data) {
		return CryptoHandler.encrypt(data, PreDefinedAlgorithm.Key.RSA_PRIVATE_KEY);
	}
	public static String decrypt(byte[] data) {
		return CryptoHandler.decrypt(data, PreDefinedAlgorithm.Key.RSA_PUBLIC_KEY);
	}
	/**
	 * 使用公钥解密
	 */
	public static String decrypt(String dataString) {
		return decrypt(Base64.getDecoder().decode(dataString.getBytes(StandardCharsets.UTF_8)));
	}

	public static void main(String[] args) {
		String s = encrypt("Hello World");
		System.out.println(s);
		String decrypt = decrypt(s);
		System.out.println(decrypt);
	}
}


}

class CryptoHandler {
/**
 * 加密
 */
public static String encrypt(String data, Key key) {
	try {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
	} catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException |
	         InvalidKeyException e) {
		// todo 记录异常情况
		throw new DataStructureException();
	}
}

/**
 * 解密
 */
public static String decrypt(byte[] data, Key key) {
	try {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, key);

		return new String(cipher.doFinal(data));
	} catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException |
	         InvalidKeyException e) {
		// todo 记录异常情况
		throw new DataStructureException();
	}
}
}
