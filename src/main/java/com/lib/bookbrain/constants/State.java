package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 状态枚举
 *
 * @author yunxia
 */
@Getter
public enum State {
   /**
    *
    */
   OFF(Value.i00),
   /**
    *
    */
   ON(Value.i01),
   ;

private final Integer value;

State(Integer value) {
   this.value = value;
}
}
