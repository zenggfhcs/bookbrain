package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.annotation.AroundDelete;
import com.lib.bookbrain.annotation.AroundGet;
import com.lib.bookbrain.annotation.AroundUpdate;
import com.lib.bookbrain.constants.Authority;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.model.*;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.entity.User;
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
public Response getBy(Payload<Book> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.BOOK_GET);
   return baseService.getBy(payload);
}

@Override
public Response create(Payload<Book> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.BOOK_CREATE);
   return baseService.create(payload);
}

@AroundGet
@Override
public Response getById(Payload<Book> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.BOOK_GET);
   return baseService.getById(payload);
}

@AroundUpdate
@Override
public Response update(Payload<Book> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.BOOK_UPDATE);
   return baseService.getById(payload);
}

@AroundDelete
@Override
public Response delete(Payload<Book> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.BOOK_DELETE);
   return baseService.delete(payload);
}
}
