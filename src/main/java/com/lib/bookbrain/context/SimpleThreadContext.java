package com.lib.bookbrain.context;

import org.springframework.stereotype.Component;

@Component
public class SimpleThreadContext<T> {
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
