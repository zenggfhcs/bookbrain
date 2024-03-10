package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookInfoFilter;

public interface BookInfoService extends BaseService<BookInfo, BookInfoFilter> {
@Override
Response getBy(FilterPayload<BookInfo, BookInfoFilter> payload);

@Override
Response create(Payload<BookInfo> payload);

@Override
Response getById(Payload<BookInfo> payload);

@Override
Response update(Payload<BookInfo> payload);

@Override
Response delete(Payload<BookInfo> payload);
}
