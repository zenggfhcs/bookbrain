package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.ClcIndex;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.ClcIndexFilter;

public interface ClcIndexService extends BaseService<ClcIndex, ClcIndexFilter> {
Response firstLevel();

Response getByKeyword(String key);

Response getByParent(Integer parent);
}
