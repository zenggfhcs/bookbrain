package com.lib.bookbrain.constant;

import lombok.Getter;

/**
 * 状态枚举
 *
 * @author yunxia
 */
@Getter
public enum State {
	/**
	 * 关
	 */
	DISABLE(Value.i00),
	/**
	 * 开
	 */
	ENABLE(Value.i01),
	;

private final Integer value;

State(Integer value) {
	this.value = value;
}
}
