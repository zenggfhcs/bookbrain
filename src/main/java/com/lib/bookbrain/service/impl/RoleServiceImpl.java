package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.RoleMapper;
import com.lib.bookbrain.model.entity.Role;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.RoleFilter;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.BaseService;
import com.lib.bookbrain.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

private final RoleMapper roleMapper;

private final BaseService<Role, RoleFilter> baseService;

private final SimpleThreadContext<TokenInfo> threadContext;

public RoleServiceImpl(SimpleThreadContext<TokenInfo> threadContext, RoleMapper roleMapper) {
	this.threadContext = threadContext;
	this.roleMapper = roleMapper;
	baseService = new BaseServiceImpl<>(threadContext, roleMapper);
}

@Override
public Response list() {
	return baseService.list();
}

@Override
public Response create(Payload<Role> payload) {
	return baseService.create(payload);
}

@Override
public Response getById(Payload<Role> payload) {
	return baseService.getById(payload);
}

@Override
public Response update(Payload<Role> payload) {
	return baseService.update(payload);
}

@Override
public Response delete(Payload<Role> payload) {
	return baseService.delete(payload);
}

@Override
public Response filteredList(FilterPayload<Role, RoleFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
public Response tokenRole() {
	TokenInfo _tokenInfo = threadContext.get();
	Role _r = roleMapper.getByUserId(_tokenInfo.getAud());
	return Response.success(_r);
}

@Override
public Response addPermission(Payload<Role> payload) {
	int _addResultCount = roleMapper.addPermission(payload.getEntity());
	if (_addResultCount == 0) {
		return Response.error(ResponseInfo.ERROR);
	}
	return Response.success();
}

@Override
public Response removePermission(Payload<Role> payload) {
	int _addResultCount = roleMapper.removePermission(payload.getEntity());
	if (_addResultCount == 0) {
		return Response.error(ResponseInfo.ERROR);
	}
	return Response.success();
}

}
