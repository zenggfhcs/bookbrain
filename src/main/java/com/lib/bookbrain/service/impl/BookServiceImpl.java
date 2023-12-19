package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.model.*;
import com.lib.bookbrain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
private final BookMapper bookMapper;
private final BaseServiceImpl<Book> baseService;

@Autowired
public BookServiceImpl(BookMapper bookMapper) {
   this.bookMapper = bookMapper;
   baseService = new BaseServiceImpl<>(bookMapper);
}

@AroundGet
@Override
public Response getBy(Payload<Book> payload, Filter filter) {
   return baseService.getBy(payload, filter);
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
