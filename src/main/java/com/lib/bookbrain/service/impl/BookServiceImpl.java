package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.comm.TokenBody;
import com.lib.bookbrain.model.comm.filters.BookFilter;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yunxia
 */
@Service
public class BookServiceImpl implements BookService {
private final BookMapper bookMapper;
private final BaseServiceImpl<Book, BookFilter> baseService;

@Autowired
public BookServiceImpl(BookMapper bookMapper, SimpleThreadContext<TokenBody> threadContext) {
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
