package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.dao.EnumMapper;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.entity.MyEnum;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookFilter;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yunxia
 */
@Service
public class BookServiceImpl implements BookService {

private final BookMapper bookMapper;

private final EnumMapper enumMapper;

private final BaseServiceImpl<Book, BookFilter> baseService;

public BookServiceImpl(BookMapper bookMapper, EnumMapper enumMapper, SimpleThreadContext<TokenInfo> threadContext) {
	this.bookMapper = bookMapper;
	this.enumMapper = enumMapper;
	baseService = new BaseServiceImpl<>(threadContext, bookMapper);
}

@Override
public Response list() {
	return baseService.list();
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
	return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Payload<Book> payload) {
	return baseService.delete(payload);
}

@Override
public Response filteredList(FilterPayload<Book, BookFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
public Response getBookDamageLevelList() {
	List<MyEnum> _list = enumMapper.getEnumsByGroup("bookDamageLevel");
	return Response.success(_list);
}

@Override
public Response getBookInfoByKeyword(String key) {
	List<BookInfo> _list = bookMapper.getBookInfoByKeyword(key);
	return Response.success(_list);
}

}
