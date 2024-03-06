package com.lib.bookbrain.dto.filter;

import com.lib.bookbrain.constant.Default;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseFilter {

protected FilterItem<LocalDateTime> creationTime;

protected FilterItem<LocalDateTime> lastUpdatedTime;

protected FilterItem<Integer> page;

public BaseFilter() {
	init();
}

private void init() {
	creationTime = Default.LOCAL_DATE_TIME_RANGE;
	lastUpdatedTime = Default.LOCAL_DATE_TIME_RANGE;
	page = Default.PAGE_RANGE;
}
}
