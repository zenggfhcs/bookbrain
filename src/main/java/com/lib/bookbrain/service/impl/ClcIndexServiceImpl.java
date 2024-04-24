package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.ClcIndexMapper;
import com.lib.bookbrain.model.entity.ClcIndex;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.ClcIndexFilter;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.BaseService;
import com.lib.bookbrain.service.ClcIndexService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClcIndexServiceImpl implements ClcIndexService {

private final ClcIndexMapper clcIndexMapper;

private final BaseService<ClcIndex, ClcIndexFilter> baseService;

public ClcIndexServiceImpl(SimpleThreadContext<TokenInfo> threadContext, ClcIndexMapper clcIndexMapper) {
	this.clcIndexMapper = clcIndexMapper;
	baseService = new BaseServiceImpl<>(threadContext, clcIndexMapper);
}

@Override
public Response list() {
	return baseService.list();
}

@Override
public Response create(Payload<ClcIndex> payload) {
	return baseService.create(payload);
}

@Override
public Response getById(Payload<ClcIndex> payload) {
	return baseService.getById(payload);
}

@Override
public Response update(Payload<ClcIndex> payload) {
	return baseService.update(payload);
}

@Override
public Response delete(Payload<ClcIndex> payload) {
	return baseService.delete(payload);
}

@Override
public Response filteredList(FilterPayload<ClcIndex, ClcIndexFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
public Response firstLevel() {
	List<ClcIndex> _list = clcIndexMapper.firstLevel();
	return Response.success(_list);
}

@Override
public Response getByKeyword(String key) {
	List<ClcIndex> _list = clcIndexMapper.getByKeyword(key);
	return Response.success(_list);
}

@Override
public Response getByParent(Integer parent) {
	List<ClcIndex> _list = clcIndexMapper.getByParent(parent);
	return Response.success(_list);
}
}
