package com.lib.bookbrain.constant;

import com.lib.bookbrain.model.comm.FilterItem;

import java.time.LocalDateTime;

public class Default {

    public static final Object OBJECT_VALUE = null;

    public static final Integer INTEGER = 0;

    /* ============================ filter ============================ */
    public static final LocalDateTime FILTER_MIN_TIME = LocalDateTime.of(2023, 1, 1, 0, 0);

    public static final LocalDateTime FILTER_MAX_TIME = LocalDateTime.of(2038, 1, 1, 0, 0);

    public static final FilterItem<LocalDateTime> LOCAL_DATE_TIME_RANGE = new FilterItem<>(Default.FILTER_MIN_TIME,
            Default.FILTER_MAX_TIME);

    public static final FilterItem<Integer> PAGE_RANGE = new FilterItem<>(0, 10);
    /* ============================ filter ============================ */

}
