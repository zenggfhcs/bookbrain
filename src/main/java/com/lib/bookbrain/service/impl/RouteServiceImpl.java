package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.RouteMapper;
import com.lib.bookbrain.model.entity.RouteItem;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BaseFilter;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

private final RouteMapper routeMapper;
private final BaseServiceImpl<RouteItem, BaseFilter> baseService;

public RouteServiceImpl(SimpleThreadContext<TokenInfo> threadContext, RouteMapper routeMapper) {
	this.routeMapper = routeMapper;
	baseService = new BaseServiceImpl<>(threadContext, routeMapper);
}

@Override
public Response list() {
	return baseService.list();
}

@Override
public Response create(Payload<RouteItem> payload) {
	return baseService.create(payload);
}

@Override
public Response getById(Payload<RouteItem> payload) {
	return null;
}

@Override
public Response update(Payload<RouteItem> payload) {
	return baseService.update(payload);
}

@Override
public Response delete(Payload<RouteItem> payload) {
	return baseService.delete(payload);
}

@Override
public Response filteredList(FilterPayload<RouteItem, BaseFilter> payload) {
	return null;
}

@Override
public Response getFirstLevel() {
	List<RouteItem> _list = routeMapper.getFirstLevel();
	return Response.success(_list);
}
}
