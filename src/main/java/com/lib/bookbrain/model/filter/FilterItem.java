package com.lib.bookbrain.model.filter;

import lombok.Data;

@Data
public class FilterItem<T> {

private T start;

private T end;

public FilterItem(T s, T e) {
	start = s;
	end = e;
}
}
