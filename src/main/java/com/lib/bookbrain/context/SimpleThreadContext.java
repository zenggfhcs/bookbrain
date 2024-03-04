package com.lib.bookbrain.context;

import org.springframework.stereotype.Component;

/**
 * 泛型封装 {@link ThreadLocal}
 *
 * @param <T> 任意类型
 * @author yunxia
 */
@Component
public class SimpleThreadContext<T> { // 相同类型T的注入获取到的对象是同一个，不同类型 T之间在单例模式下有无冲突有待验证

private final ThreadLocal<T> threadLocal;

public SimpleThreadContext() {
	threadLocal = new ThreadLocal<>();
}

public void set(T t) {
	threadLocal.set(t);
}

public T get() {
	return threadLocal.get();
}

public void remove() {
	threadLocal.remove();
}

}
