package com.lib.bookbrain.fnuction;

/**
 * three parameter consumer
 * @param <K> 1
 * @param <V> 2
 * @param <S> 3
 */
@FunctionalInterface
public interface TriConsumer<K, V, S> {
   void accept(K k, V v, S s);
}
