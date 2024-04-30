package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundLog;
import com.lib.bookbrain.constant.LogType;
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
@AroundLog(value = "获取角色列表", type = LogType.R)
public Response list() {
	return baseService.list();
}

@Override
@AroundLog(value = "创建角色", type = LogType.C)
public Response create(Payload<Role> payload) {
	return baseService.create(payload);
}

@Override
@AroundLog(value = "获取单一角色", type = LogType.R)
public Response getById(Payload<Role> payload) {
	return baseService.getById(payload);
}

@Override
@AroundLog(value = "更新角色", type = LogType.U)
public Response update(Payload<Role> payload) {
	return baseService.update(payload);
}

@Override
@AroundLog(value = "删除角色", type = LogType.D)
public Response delete(Payload<Role> payload) {
	return baseService.delete(payload);
}

@Override
@AroundLog(value = "查询角色列表(过滤)", type = LogType.R)
public Response filteredList(FilterPayload<Role, RoleFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
@AroundLog(value = "查询token用户角色", type = LogType.R)
public Response tokenRole() {
	TokenInfo _tokenInfo = threadContext.get();
	Role _r = roleMapper.getByUserId(_tokenInfo.getAud());
	return Response.success(_r);
}

@Override
@AroundLog(value = "添加角色权限", type = LogType.C)
public Response addPermission(Payload<Role> payload) {
	int _addResultCount = roleMapper.addPermission(payload.getEntity());
	if (_addResultCount == 0) {
		return Response.error(ResponseInfo.ERROR);
	}
	return Response.success();
}

@Override
@AroundLog(value = "移除角色权限", type = LogType.D)
public Response removePermission(Payload<Role> payload) {
	int _removeResultCount = roleMapper.removePermission(payload.getEntity());
	if (_removeResultCount == 0) {
		return Response.error(ResponseInfo.ERROR);
	}
	return Response.success();
}

@Override
@AroundLog(value = "添加角色路由", type = LogType.C)
public Response addRoute(Payload<Role> payload) {
	int _addResultCount = roleMapper.addRoute(payload.getEntity());
	if (_addResultCount == 0) {
		return Response.error(ResponseInfo.ERROR);
	}
	return Response.success();
}

@Override
@AroundLog(value = "移除角色路由", type = LogType.D)
public Response removeRoute(Payload<Role> payload) {
	int _removeResultCount = roleMapper.removeRoute(payload.getEntity());
	if (_removeResultCount == 0) {
		return Response.error(ResponseInfo.ERROR);
	}
	return Response.success();
}

}
