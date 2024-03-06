package com.lib.bookbrain.utils;

import com.lib.bookbrain.exception.DataStructureException;
import com.lib.bookbrain.pojo.TokenInfo;

import java.util.Base64;

public class Base64Coder {
/**
 * base64 编码时，如果长度不为 3 的倍数，会填充 =，使得编码后字符串长度为 3 的倍数
 *
 * @param data 可能是去除了编码填充的base64字符串
 * @return 填充 = 后的字符串
 */
private static String fill(String data) {
	int _fc = data.length() % 4;

	if (_fc > 0) {
		data += "=".repeat(4 - _fc);
	}

	return data;
}

private static String refill(String data) {
	// todo indexOf -1 异常
	int _ii = data.indexOf("=");

	return _ii == -1 ?
			data
			:
			data.substring(0, _ii);
}


public static String encode(String data) {
	return encode(data, false);
}

public static String encode(String data, boolean refill) {
	try {
		String res = new String(encode(data.getBytes()));
		if (refill) {
			res = refill(res);
		}
		return res;
	} catch (Exception e) {
		// todo
		throw new DataStructureException();
	}
}


public static byte[] encode(byte[] data) {
	return Base64.getEncoder().encode(data);
}


public static String decode(String data) {
	try {
		data = fill(data);
		data = new String(decode(data.getBytes()));
		return data;
	} catch (Exception e) {
		// todo
		e.printStackTrace();
		throw new DataStructureException();
	}
}

public static byte[] decode(byte[] data) {
	return Base64.getDecoder().decode(data);
}

public static void main(String[] args) {

	TokenInfo _info = new TokenInfo();
	{
		_info.setAud(1);
		_info.setNbf(System.currentTimeMillis());
		_info.setExp(System.currentTimeMillis() + 7 * 24 * 3600);
		_info.setJti("1635276938@qq.com");
	}
	String data = Json.stringify(_info);
	System.out.println(encode(data));
	data = encode(data, true);
	System.out.println(data.length());
	System.out.println(decode(data));

}
}
