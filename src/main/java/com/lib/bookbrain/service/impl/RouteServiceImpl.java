package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundLog;
import com.lib.bookbrain.constant.LogType;
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

import java.util.HashMap;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
private final RouteMapper routeMapper;
private final BaseServiceImpl<RouteItem, BaseFilter> baseService;
SimpleThreadContext<TokenInfo> threadContext;

public RouteServiceImpl(SimpleThreadContext<TokenInfo> threadContext, RouteMapper routeMapper) {
	this.threadContext = threadContext;
	this.routeMapper = routeMapper;
	baseService = new BaseServiceImpl<>(threadContext, routeMapper);
}

@Override
@AroundLog(value = "获取路由列表", type = LogType.R)
public Response list() {
	return baseService.list();
}

@Override
@AroundLog(value = "创建路由", type = LogType.C)
public Response create(Payload<RouteItem> payload) {
	return baseService.create(payload);
}

@Override
@AroundLog(value = "获取单一路由", type = LogType.R)
public Response getById(Payload<RouteItem> payload) {
	return null;
}

@Override
@AroundLog(value = "更新路由", type = LogType.U)
public Response update(Payload<RouteItem> payload) {
	return baseService.update(payload);
}

@Override
@AroundLog(value = "删除路由", type = LogType.D)
public Response delete(Payload<RouteItem> payload) {
	return baseService.delete(payload);
}

@Override
@AroundLog(value = "获取路由列表(过滤)", type = LogType.R)
public Response filteredList(FilterPayload<RouteItem, BaseFilter> payload) {
	return null;
}

@Override
@AroundLog(value = "获取一级路由", type = LogType.R)
public Response getFirstLevel() {
	List<RouteItem> _list = routeMapper.getFirstLevel();
	return Response.success(_list);
}

@Override
@AroundLog(value = "获取路由列表-通过分组", type = LogType.R)
public Response getByGroup(String group) {
	Integer _userId = threadContext.get().getAud();
	HashMap<String, Object> _map = new HashMap<>();
	_map.put("userId", _userId);
	_map.put("group", group);
	List<RouteItem> _list = routeMapper.getByGroup(_map);
	return Response.success(_list);
}
}
