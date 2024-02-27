package com.lib.bookbrain.service;

import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.comm.filters.BookInfoFilter;
import com.lib.bookbrain.model.entity.BookInfo;

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
