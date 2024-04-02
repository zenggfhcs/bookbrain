package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookInfoMapper;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.BookInfoService;
import org.springframework.stereotype.Service;

/**
 * @author yunxia
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {

private final BookInfoMapper bookInfoMapper;

private final BaseServiceImpl<BookInfo> baseService;

public BookInfoServiceImpl(BookInfoMapper bookInfoMapper, SimpleThreadContext<TokenInfo> threadContext) {
	this.bookInfoMapper = bookInfoMapper;
	baseService = new BaseServiceImpl<>(threadContext, bookInfoMapper);
}

@Override
public Response list() {
	return baseService.list();
}

@Override
public Response create(BookInfo entity) {
	return baseService.create(entity);
}

@AroundGet
@Override
public Response getById(Integer id) {
	return baseService.getById(id);
}

@AroundUpdate
@Override
public Response update(Payload<BookInfo> payload) {
	return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Integer id) {
	return baseService.delete(id);
}

}
