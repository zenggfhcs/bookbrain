package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookInfoMapper;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookInfoFilter;
import com.lib.bookbrain.pojo.TokenInfo;
import com.lib.bookbrain.service.BookInfoService;
import org.springframework.stereotype.Service;

/**
 * @author yunxia
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {

private final BookInfoMapper bookInfoMapper;

private final BaseServiceImpl<BookInfo, BookInfoFilter> baseService;

public BookInfoServiceImpl(BookInfoMapper bookInfoMapper, SimpleThreadContext<TokenInfo> threadContext) {
	this.bookInfoMapper = bookInfoMapper;
	baseService = new BaseServiceImpl<>(threadContext, bookInfoMapper);
}

@AroundGet
@Override
public Response getBy(FilterPayload<BookInfo, BookInfoFilter> payload) {
	return baseService.getBy(payload);
}

@Override
public Response create(Payload<BookInfo> payload) {
	return baseService.create(payload);
}

@AroundGet
@Override
public Response getById(Payload<BookInfo> payload) {
	return baseService.getById(payload);
}

@AroundUpdate
@Override
public Response update(Payload<BookInfo> payload) {
	return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Payload<BookInfo> payload) {
	return baseService.delete(payload);
}

}
