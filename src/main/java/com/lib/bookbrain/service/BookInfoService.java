package com.lib.bookbrain.service;

import com.lib.bookbrain.model.dto.Payload;
import com.lib.bookbrain.model.dto.Response;
import com.lib.bookbrain.model.entity.BookInfo;

public interface BookInfoService extends BaseService<BookInfo> {
@Override
Response getBy(Payload<BookInfo> payload);

@Override
Response create(Payload<BookInfo> payload);

@Override
Response getById(Payload<BookInfo> payload);

@Override
Response update(Payload<BookInfo> payload);

@Override
Response delete(Payload<BookInfo> payload);
}
