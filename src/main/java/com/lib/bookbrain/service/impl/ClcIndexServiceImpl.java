package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundLog;
import com.lib.bookbrain.constant.LogType;
import com.lib.bookbrain.constant.ResponseInfo;
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
import java.util.Optional;

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
@AroundLog(value = "查询分类号列表", type = LogType.R)
public Response list() {
	return baseService.list();
}

@Override
@AroundLog(value = "创建分类号", type = LogType.C)
public Response create(Payload<ClcIndex> payload) {
	ClcIndex _clcIndex = payload.getEntity();
	// todo 查一下是否重复
	ClcIndex _keyCi = clcIndexMapper.getByKey(_clcIndex.getKey());
	if (Optional.ofNullable(_keyCi).isPresent()) {
		return Response.error(ResponseInfo.KEY_REPEAT);
	}
	// todo 查一下是否属于这个分类
	int _startWithCount = clcIndexMapper.parentStartWith(_clcIndex);
	if (_startWithCount == 0) {
		return Response.error(ResponseInfo.PARENT_FAILED);
	}
	return baseService.create(payload);
}

@Override
@AroundLog(value = "获取单一分类号", type = LogType.R)
public Response getById(Payload<ClcIndex> payload) {
	return baseService.getById(payload);
}

@Override
@AroundLog(value = "更新分类", type = LogType.U)
public Response update(Payload<ClcIndex> payload) {
	ClcIndex _clcIndex = payload.getEntity();
	// todo 查一下是否重复
	ClcIndex _keyCi = clcIndexMapper.getByKey(_clcIndex.getKey());
	if (Optional.ofNullable(_keyCi).isPresent()) {
		return Response.error(ResponseInfo.KEY_REPEAT);
	}
	return baseService.update(payload);
}

@Override
@AroundLog(value = "删除分类", type = LogType.D)
public Response delete(Payload<ClcIndex> payload) {
	// todo 检查是否存在子项，存在则删除失败
	List<ClcIndex> _byParent = clcIndexMapper.getByParent(payload.getId());
	if (!_byParent.isEmpty()) {
		return Response.error(ResponseInfo.THERE_ARE_UNDELETED_SUB_KEYS);
	}
	return baseService.delete(payload);
}

@Override
@AroundLog(value = "获取分类列表(过滤)", type = LogType.R)
public Response filteredList(FilterPayload<ClcIndex, ClcIndexFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
@AroundLog(value = "获取一级分类列表", type = LogType.R)
public Response firstLevel() {
	List<ClcIndex> _list = clcIndexMapper.firstLevel();
	return Response.success(_list);
}

@Override
@AroundLog(value = "获取分类列表-通过关键字", type = LogType.R)
public Response getByKeyword(String key) {
	List<ClcIndex> _list = clcIndexMapper.getByKeyword(key);
	return Response.success(_list);
}

@Override
@AroundLog(value = "获取分类列表-通过夫分类ID", type = LogType.R)
public Response getByParent(Integer parent) {
	List<ClcIndex> _list = clcIndexMapper.getByParent(parent);
	return Response.success(_list);
}
}
