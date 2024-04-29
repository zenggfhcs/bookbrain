package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.RouteItem;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BaseFilter;

public interface RouteService extends BaseService<RouteItem, BaseFilter> {
Response getFirstLevel();
}
