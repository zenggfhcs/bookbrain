package com.lib.bookbrain.model.filter;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseFilter {

protected FilterItem<LocalDateTime> creationTime;

protected FilterItem<LocalDateTime> lastUpdatedTime;

protected FilterItem<Integer> page;

}
