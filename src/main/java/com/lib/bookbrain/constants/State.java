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

State(Integer value) {
   this.value = value;
}

private final Integer value;
}
