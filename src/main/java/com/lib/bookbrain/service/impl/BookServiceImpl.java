package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author yunxia
 */
@Service
public class BookServiceImpl implements BookService {

private final BookMapper bookMapper;

private final BaseServiceImpl<Book> baseService;

public BookServiceImpl(BookMapper bookMapper, SimpleThreadContext<TokenInfo> threadContext) {
	this.bookMapper = bookMapper;
	baseService = new BaseServiceImpl<>(threadContext, bookMapper);
}

@Override
public Response list() {
	return baseService.list();
}

@Override
public Response create(Book entity) {
	return baseService.create(entity);
}

@AroundGet
@Override
public Response getById(Integer id) {
	return baseService.getById(id);
}

@AroundUpdate
@Override
public Response update(Payload<Book> payload) {
	return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Integer id) {
	return baseService.delete(id);
}
}
