package com.lib.bookbrain.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MyFile {
private static final ClassLoader classLoader;

private static final Map<String, String> temp;

static {
	classLoader = MyFile.class.getClassLoader();
	temp = new HashMap<>();
}

public static String read(String path) {
	if (temp.containsKey(path)) {
		return temp.get(path);
	}

	try (InputStream reader = classLoader.getResourceAsStream(path)) {
		if (reader != null) {
			String _value = new String(reader.readAllBytes());

			// 存起来，下次直接获取
			temp.put(path, _value);
			return _value;
		}
	} catch (IOException e) {
		throw new RuntimeException(e);
	}
	return null;
}
}
