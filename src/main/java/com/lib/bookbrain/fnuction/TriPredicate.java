package com.lib.bookbrain.fnuction;

/**
 * three parameter predicate
 *
 * @param <K> 1
 * @param <V> 2
 * @param <S> 3
 */
@FunctionalInterface
public interface TriPredicate<K, V, S> {
    Boolean test(K k, V v, S s);
}