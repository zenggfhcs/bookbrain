package com.lib.bookbrain.fnuction;

/**
 * three parameter consumer
 *
 * @param <K> 1
 * @param <V> 2
 * @param <S> 3
 */
@FunctionalInterface
public interface TriConsumer<K, V, S> {
    /**
     * fill or
     *
     * @param k 1
     * @param v 2
     * @param s 3
     */
    void accept(K k, V v, S s);
}
