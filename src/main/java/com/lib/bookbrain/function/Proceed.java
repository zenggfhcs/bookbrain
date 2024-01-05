package com.lib.bookbrain.function;

@FunctionalInterface
public interface Proceed<T, U, R> {
   R run(T t, U u);
}
