package com.lib.bookbrain.constant;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum TemplateInfo {
	REGISTER_CONFIRMED("register-confirmed.ftl", new HashMap<>()),
	;
final Map<String, Object> map;

final String name;

TemplateInfo(String name, Map<String, Object> map) {
	this.name = "/freemarker/" + name;
	this.map = map;
}

public TemplateInfo fill(String key, Object value) {
	map.put(key, value);
	return this;
}
}
