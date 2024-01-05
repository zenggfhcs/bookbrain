package com.lib.bookbrain.constants;

import lombok.Getter;

/**
 * 开还是关？
 */
@Getter
public enum State {
   OFF(0), ON(1);

State(Integer value) {
   this.value = value;
}

private final Integer value;
}
