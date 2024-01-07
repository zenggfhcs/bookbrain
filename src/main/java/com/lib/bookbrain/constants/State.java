package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 开还是关？
 */
@Getter
public enum State {
   /**
    *
    */
   OFF(Value.v00),
   /**
    *
    */
   ON(Value.v01),
   ;

private final Integer value;

State(Integer value) {
   this.value = value;
}
}
