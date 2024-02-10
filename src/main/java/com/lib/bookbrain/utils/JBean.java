package com.lib.bookbrain.utils;

import com.lib.bookbrain.context.MyApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * 封装 get bean
 */
public class JBean {
private static final ApplicationContext context;

static {
   context = MyApplicationContext.getApplicationContext();
}

public static Object get(String name) {
   return context.getBean(name);
}

public static <T> T get(String name, Class<T> type) {
   return context.getBean(name, type);
}

public static <T> T get(Class<T> type) {
   return context.getBean(type);
}
}
