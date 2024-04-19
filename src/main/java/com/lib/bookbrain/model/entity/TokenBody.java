package com.lib.bookbrain.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenBody extends Entity {

private String token;

public static TokenBody gByToken(String token) {
	TokenBody _body = new TokenBody();
	_body.setToken(token);
	return _body;
}
}
