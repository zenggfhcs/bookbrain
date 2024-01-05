package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.Filter;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;

public interface BookInfoService extends BaseService<BookInfo> {
@Override
Response getBy(Payload<BookInfo> payload, Filter filter);

@Override
Response create(Payload<BookInfo> payload);

@Override
Response getById(Payload<BookInfo> payload);

@Override
Response update(Payload<BookInfo> payload);

@Override
Response delete(Payload<BookInfo> payload);
}
