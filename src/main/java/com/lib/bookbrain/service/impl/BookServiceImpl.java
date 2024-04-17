package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.dao.DebitMapper;
import com.lib.bookbrain.dao.EnumMapper;
import com.lib.bookbrain.model.entity.*;
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

@Override
public Response borrow(Book book) {
	Integer userId = threadContext.get().getAud();
	User _u = new User();
	_u.setId(userId);
	book.setUpdatedBy(_u);

	int _bc = debitMapper.getCountByUserId(userId);
	if (_bc >= 10) {// 借阅数已达上限
		return Response.error(ResponseInfo.BORROW_NUM_UPPER_LIMIT);
	}

	List<Debit> _ebs = debitMapper.getExpiredByUserId(userId);
	if (_ebs != null && !_ebs.isEmpty()) {// 存在逾期未还
		return Response.error(ResponseInfo.HAS_EXPIRED_BORROW);
	}

	int _dc = debitMapper.getBookCountByBookIdAndUserId(book.getId(), userId);
	if (_dc > 0) {// 当前已借阅该图书
		return Response.error(ResponseInfo.IS_BORROWED);
	}
	// 借一下看看
	int _uc = bookMapper.borrow(book);
	if (_uc == 0) {
		return Response.error(ResponseInfo.THE_BOOK_HAS_BEEN_BORROWED);
	}

	Debit debit = Debit.generate(book, _u);
	int _ic = debitMapper.insert(debit);
	if (_ic == 0) {
		return Response.error(ResponseInfo.ERROR);
	}

	return Response.success();
}

@Override
public Response escheat(Book book) {
	Integer userId = threadContext.get().getAud();
	User _u = new User();
	_u.setId(userId);
	book.setUpdatedBy(_u);

	int _rc = debitMapper.escheat(book);
	if (_rc == 0) {
		return Response.error(ResponseInfo.ESCHEAT_FAILED);
	}
	return Response.success();
}
}
