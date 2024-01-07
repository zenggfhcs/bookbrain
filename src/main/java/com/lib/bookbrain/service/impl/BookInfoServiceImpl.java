package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.annotation.AroundDelete;
import com.lib.bookbrain.annotation.AroundGet;
import com.lib.bookbrain.annotation.AroundUpdate;
import com.lib.bookbrain.constants.Authority;
import com.lib.bookbrain.dao.BookInfoMapper;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookInfoServiceImpl implements BookInfoService {

private final BookInfoMapper bookInfoMapper;

private final BaseServiceImpl<BookInfo> baseService;

@Autowired
public BookInfoServiceImpl(BookInfoMapper bookInfoMapper) {
   this.bookInfoMapper = bookInfoMapper;
   baseService = new BaseServiceImpl<>(bookInfoMapper);
}

@AroundGet
@Override
public Response getBy(Payload<BookInfo> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.BOOK_INFO_GET);
   return baseService.getBy(payload);
}

@Override
public Response create(Payload<BookInfo> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.BOOK_INFO_CREATE);
   return baseService.create(payload);
}

@AroundGet
@Override
public Response getById(Payload<BookInfo> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.BOOK_INFO_GET);
   return baseService.getById(payload);
}

@AroundUpdate
@Override
public Response update(Payload<BookInfo> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.BOOK_INFO_UPDATE);
   return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Payload<BookInfo> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.BOOK_INFO_DELETE);
   return baseService.delete(payload);
}

}
