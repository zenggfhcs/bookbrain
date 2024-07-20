package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundLog;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.constant.LogType;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookInfoMapper;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.dao.DebitMapper;
import com.lib.bookbrain.exception.BaseException;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookInfoFilter;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.BookInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yunxia
 */
@Service
@Transactional
public class BookInfoServiceImpl implements BookInfoService {
private final SimpleThreadContext<TokenInfo> threadContext;

private final BookInfoMapper bookInfoMapper;

private final BookMapper bookMapper;

private final DebitMapper debitMapper;

private final BaseServiceImpl<BookInfo, BookInfoFilter> baseService;

public BookInfoServiceImpl(BookInfoMapper bookInfoMapper, SimpleThreadContext<TokenInfo> threadContext, BookMapper bookMapper, DebitMapper debitMapper) {
	this.threadContext = threadContext;
	this.bookInfoMapper = bookInfoMapper;
	this.bookMapper = bookMapper;
	this.debitMapper = debitMapper;
	baseService = new BaseServiceImpl<>(threadContext, bookInfoMapper);
}

@Override
@AroundLog(value = "查询书籍信息列表", type = LogType.R)
public Response list() {
	return baseService.list();
}

@Override
@AroundLog(value = "创建书籍信息", type = LogType.C)
public Response create(Payload<BookInfo> payload) {
	return baseService.create(payload);
}

@Override
@AroundLog(value = "查询单一书籍信息", type = LogType.R)
public Response getById(Payload<BookInfo> payload) {
	return baseService.getById(payload);
}

@AroundUpdate
@Override
@AroundLog(value = "更新书籍信息", type = LogType.U)
public Response update(Payload<BookInfo> payload) {
	return baseService.update(payload);
}

@AroundDelete
@Override
@AroundLog(value = "删除书籍", type = LogType.D)
public Response delete(Payload<BookInfo> payload) {
	return baseService.delete(payload);
}

@Override
@AroundLog(value = "查询书籍信息列表(过滤)", type = LogType.R)
public Response filteredList(FilterPayload<BookInfo, BookInfoFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
@AroundLog(value = "书籍检索-快速", type = LogType.R)
public Response quickQuery(FilterPayload<BookInfo, BookInfoFilter> payload) {
	Map<String, Object> _map = new HashMap<>();
	{
		List<BookInfo> _list = bookInfoMapper.quickQuery(payload);
		_map.put("list", _list);
	}
	{
		int _length = bookInfoMapper.quickQueryCount(payload);
		_map.put("length", _length);
	}
	return Response.success(_map);
}

@Override
@AroundLog(value = "书籍检索-分类", type = LogType.R)
public Response typeQuery(String bookType, List<String> orders) {
	return null;
}

@Override
@AroundLog(value = "书籍检索-关键字", type = LogType.R)
public Response getByKeyword(String key) {
	List<BookInfo> _list = bookInfoMapper.getByKeyword(key);
	return Response.success(_list);
}

}
