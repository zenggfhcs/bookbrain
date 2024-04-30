package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundLog;
import com.lib.bookbrain.constant.LogType;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.dao.DebitMapper;
import com.lib.bookbrain.dao.EnumMapper;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.entity.MyEnum;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookFilter;
import com.lib.bookbrain.model.pojo.CollectionInfo;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yunxia
 */
@Service
public class BookServiceImpl implements BookService {

private final SimpleThreadContext<TokenInfo> threadContext;

private final BookMapper bookMapper;

private final EnumMapper enumMapper;

private final BaseServiceImpl<Book, BookFilter> baseService;
private final DebitMapper debitMapper;

public BookServiceImpl(BookMapper bookMapper, EnumMapper enumMapper, SimpleThreadContext<TokenInfo> threadContext, DebitMapper debitMapper) {
	this.bookMapper = bookMapper;
	this.enumMapper = enumMapper;
	this.threadContext = threadContext;
	baseService = new BaseServiceImpl<>(threadContext, bookMapper);
	this.debitMapper = debitMapper;
}

@Override
@AroundLog(value = "查询书籍列表", type = LogType.R)
public Response list() {
	return baseService.list();
}

@Override
@AroundLog(value = "创建书籍", type = LogType.R)
public Response create(Payload<Book> payload) {
	return baseService.create(payload);
}

@Override
@AroundLog(value = "查询单一书籍", type = LogType.R)
public Response getById(Payload<Book> payload) {
	return baseService.getById(payload);
}

@Override
@AroundLog(value = "更新书籍", type = LogType.U)
public Response update(Payload<Book> payload) {
	return baseService.update(payload);
}

@Override
@AroundLog(value = "删除书籍", type = LogType.D)
public Response delete(Payload<Book> payload) {
	return baseService.delete(payload);
}

@Override
@AroundLog(value = "查询书籍列表(过滤)", type = LogType.R)
public Response filteredList(FilterPayload<Book, BookFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
@AroundLog(value = "获取书籍损坏级别", type = LogType.R)
public Response getBookDamageLevelList() {
	List<MyEnum> _list = enumMapper.getEnumsByGroup("bookDamageLevel");
	return Response.success(_list);
}

@Override
@AroundLog(value = "获取书籍列表-通过书籍信息ID", type = LogType.R)
public Response getByBookInfoId(Integer id) {
	List<Book> _list = bookMapper.getByBookInfoId(id);
	return Response.success(_list);
}

@Override
@AroundLog(value = "获取馆藏信息", type = LogType.R)
public Response collectionInfo() {
	List<CollectionInfo> _list = bookMapper.collectionInfo();
	return Response.success(_list);
}
}
