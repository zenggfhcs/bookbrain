package com.lib.bookbrain.security;

import com.auth0.jwt.algorithms.Algorithm;

/**
 * {@link Algorithm} 对应的枚举
 */
public enum AlgorithmType {
   HMAC(MyAlgorithm.HMAC),
   RSA(MyAlgorithm.RSA),
   ;
final Algorithm algorithm;

AlgorithmType(Algorithm algorithm) {
   this.algorithm = algorithm;
}
}
