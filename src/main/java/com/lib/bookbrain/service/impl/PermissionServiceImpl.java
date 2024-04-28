package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.PermissionMapper;
import com.lib.bookbrain.model.entity.Permission;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.PermissionFilter;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.BaseService;
import com.lib.bookbrain.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
private final PermissionMapper permissionMapper;
private final BaseService<Permission, PermissionFilter> baseService;
SimpleThreadContext<TokenInfo> threadContext;

public PermissionServiceImpl(SimpleThreadContext<TokenInfo> threadContext, PermissionMapper permissionMapper) {
	this.threadContext = threadContext;
	this.permissionMapper = permissionMapper;
	baseService = new BaseServiceImpl<>(threadContext, permissionMapper);
}

@Override
public Response list() {
	return baseService.list();
}

@Override
public Response create(Payload<Permission> payload) {
	Permission _p = payload.getEntity();
	// 权限名不可重复
	int _nameCount = permissionMapper.isExistByName(_p.getName());
	if (_nameCount > 0) {
		return Response.error(ResponseInfo.PERMISSION_NAME_REPEAT);
	}
	return baseService.create(payload);
}

@Override
public Response getById(Payload<Permission> payload) {
	return baseService.getById(payload);
}

@Override
public Response update(Payload<Permission> payload) {
	Permission _p = payload.getEntity();
	// 权限名不可重复
	int _nameCount = permissionMapper.isExistByName(_p.getName());
	if (_nameCount > 0) {
		return Response.error(ResponseInfo.PERMISSION_NAME_REPEAT);
	}
	return baseService.update(payload);
}

@Override
public Response delete(Payload<Permission> payload) {
	return baseService.delete(payload);
}

@Override
public Response filteredList(FilterPayload<Permission, PermissionFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
public Response tokenPermission() {
	Integer _operatorId = threadContext.get().getAud();
	List<Permission> _list = permissionMapper.getByUserId(_operatorId);
	return Response.success(_list);
}
}
