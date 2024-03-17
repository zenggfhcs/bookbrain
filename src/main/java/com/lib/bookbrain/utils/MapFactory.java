package com.lib.bookbrain.utils;

import java.util.HashMap;
import java.util.Map;

public class MapFactory {
private final Map<String, Object> map;

private MapFactory() {
	map = new HashMap<>();
}

public Map<String, Object> map() {
	return map;
}

public static class Builder {
	MapFactory mf;

	private Builder() {
		mf = new MapFactory();
	}

	public static Builder builder() {
		return new Builder();
	}

	public Builder fill(String k, Object v) {
		mf.map.put(k, v);
		return this;
	}

	public MapFactory build() {
		return mf;
	}
}
}
