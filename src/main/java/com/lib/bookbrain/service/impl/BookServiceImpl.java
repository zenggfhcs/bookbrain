package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.pojo.TokenInfo;
import com.lib.bookbrain.dto.filter.BookFilter;
import com.lib.bookbrain.entity.Book;
import com.lib.bookbrain.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author yunxia
 */
@Service
public class BookServiceImpl implements BookService {

private final BookMapper bookMapper;

private final BaseServiceImpl<Book, BookFilter> baseService;

public BookServiceImpl(BookMapper bookMapper, SimpleThreadContext<TokenInfo> threadContext) {
	this.bookMapper = bookMapper;
	baseService = new BaseServiceImpl<>(threadContext, bookMapper);
}

@AroundGet
@Override
public Response getBy(FilterPayload<Book, BookFilter> payload) {
	return baseService.getBy(payload);
}

@Override
public Response create(Payload<Book> payload) {
	return baseService.create(payload);
}

@AroundGet
@Override
public Response getById(Payload<Book> payload) {
	return baseService.getById(payload);
}

@AroundUpdate
@Override
public Response update(Payload<Book> payload) {
	return baseService.getById(payload);
}

@AroundDelete
@Override
public Response delete(Payload<Book> payload) {
	return baseService.delete(payload);
}
}
