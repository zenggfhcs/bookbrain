package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookInfoMapper;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.entity.ClcIndex;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookInfoFilter;
import com.lib.bookbrain.model.pojo.BookType;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.BookInfoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yunxia
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {

private final BookInfoMapper bookInfoMapper;

private final BaseServiceImpl<BookInfo, BookInfoFilter> baseService;

public BookInfoServiceImpl(BookInfoMapper bookInfoMapper, SimpleThreadContext<TokenInfo> threadContext) {
	this.bookInfoMapper = bookInfoMapper;
	baseService = new BaseServiceImpl<>(threadContext, bookInfoMapper);
}

@Override
public Response list() {
	return baseService.list();
}

@Override
public Response create(Payload<BookInfo> payload) {
	return baseService.create(payload);
}

@AroundGet
@Override
public Response getById(Payload<BookInfo> payload) {
	return baseService.getById(payload);
}

@AroundUpdate
@Override
public Response update(Payload<BookInfo> payload) {
	return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Payload<BookInfo> payload) {
	return baseService.delete(payload);
}

@Override
public Response filteredList(FilterPayload<BookInfo, BookInfoFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
public Response getTypeByKeyword(String keyword) {
	List<BookType> _list = bookInfoMapper.getTypeByKeyword(keyword);
	return Response.success(_list);
}

@Override
public Response getFirstLevelType() {
	List<ClcIndex> _list = bookInfoMapper.getFirstLevelType();
	return Response.success(_list);
}

@Override
public Response quickQuery(FilterPayload<BookInfo, BookInfoFilter> payload) {
	List<BookInfo> _list = bookInfoMapper.quickQuery(payload);
	Map<String, Object> _map = new HashMap<>();
	_map.put("list", _list);
	_map.put("length", _list.size());
	return Response.success(_map);
}

@Override
public Response typeQuery(String bookType, List<String> orders) {
	return null;
}

}
