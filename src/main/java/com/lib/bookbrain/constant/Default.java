package com.lib.bookbrain.constant;

import com.lib.bookbrain.model.filter.FilterItem;

import java.time.LocalDateTime;

public interface Default {

Object OBJECT_VALUE = null;

Integer INTEGER = 0;

/* ============================ filter ============================ */
LocalDateTime FILTER_MIN_TIME = LocalDateTime.of(2023, 1, 1, 0, 0);

LocalDateTime FILTER_MAX_TIME = LocalDateTime.of(2038, 1, 1, 0, 0);

FilterItem<LocalDateTime> LOCAL_DATE_TIME_RANGE = new FilterItem<>(Default.FILTER_MIN_TIME,
		Default.FILTER_MAX_TIME);

FilterItem<Integer> PAGE_RANGE = new FilterItem<>(0, 10);
/* ============================ filter ============================ */

}
