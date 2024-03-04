package com.lib.bookbrain.utils;

import com.lib.bookbrain.context.MyApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * 封装 get bean
 */
public class MyBean {
private static final ApplicationContext context;

static {
	context = MyApplicationContext.getApplicationContext();
}

public static Object get(String name) {
	if (name == null) {
		return null;
	}
	return context.getBean(name);
}

public static <T> T get(String name, Class<T> type) {
	if (name == null || type == null) {
		return null;
	}
	return context.getBean(name, type);
}

public static <T> T get(Class<T> type) {
	if (type == null) {
		return null;
	}
	return context.getBean(type);
}
}
