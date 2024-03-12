package com.lib.bookbrain.model.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogFilter extends BaseFilter {
private FilterItem<Long> elapsedTime;
}
