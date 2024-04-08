package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookInfoFilter;

public interface BookInfoService extends BaseService<BookInfo, BookInfoFilter> {
Response getTypeByKeyword(String key);
}
