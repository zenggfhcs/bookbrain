package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 状态枚举
 *
 * @author yunxia
 */
@Getter
public enum State {
   CLOSE(Value.i00),                      // 关
   OPEN(Value.i01),                       // 开
   ;

private final Integer value;

State(Integer value) {
   this.value = value;
}
}
