package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface BookInfoService extends BaseService<BookInfo> {

@Override
Response create(BookInfo entity);

@Override
Response getById(Integer id);

@Override
Response update(Payload<BookInfo> payload);

@Override
Response delete(Integer id);
}
