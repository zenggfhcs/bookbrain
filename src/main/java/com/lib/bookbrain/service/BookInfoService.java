package com.lib.service;

import com.lib.model.*;

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
