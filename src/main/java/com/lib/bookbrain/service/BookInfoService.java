package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookInfoFilter;

import java.util.List;

public interface BookInfoService extends BaseService<BookInfo, BookInfoFilter> {

Response getFirstLevelType();

Response quickQuery(FilterPayload<BookInfo, BookInfoFilter> payload);

Response typeQuery(String bookType, List<String> orders);

Response getByKeyword(String key);
}
