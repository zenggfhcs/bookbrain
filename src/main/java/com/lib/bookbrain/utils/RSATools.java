package com.lib.bookbrain.utils;

import com.lib.bookbrain.exception.DataStructureException;
import com.lib.bookbrain.security.PreDefinedAlgorithm;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class RSATools {
private static String decrypt(byte[] data) {
	try {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, PreDefinedAlgorithm.Key.RSA_PRIVATE_KEY);

		return new String(cipher.doFinal(data));
	} catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException |
	         InvalidKeyException e) {
		// todo 记录异常情况
		throw new DataStructureException();
	}
}

public static String decrypt(String dataString) {
	return decrypt(Base64.getDecoder().decode(dataString.getBytes(StandardCharsets.UTF_8)));
}


// 使用公钥加密数据
public static String encrypt(String data) {
	try {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, PreDefinedAlgorithm.Key.RSA_PUBLIC_KEY);
		return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
	} catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException |
	         InvalidKeyException e) {
		// todo 记录异常情况
		throw new DataStructureException();
	}
}
}
