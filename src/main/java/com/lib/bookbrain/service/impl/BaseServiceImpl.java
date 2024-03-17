package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BaseMapper;
import com.lib.bookbrain.model.entity.Entity;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BaseFilter;
import com.lib.bookbrain.pojo.TokenInfo;
import com.lib.bookbrain.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseService 的实现类
 * <br>
 * 为所有实现 BaseService 的类提供一个默认实现，
 * 通过使用这个默认实现，统一操作逻辑
 *
 * @author yunxia
 */
public class BaseServiceImpl<E extends Entity, F extends BaseFilter> implements BaseService<E, F> {

/**
 * 线程共享的 tokenInfo 对象，用于存放操作人信息
 */
protected final SimpleThreadContext<TokenInfo> threadContext;

/**
 * baseMapper
 * <br>
 * 实际使用时会被他的子接口替换
 */
protected final BaseMapper<E, F> baseMapper;

/**
 * 自动注入
 *
 * @param threadContext tokenBody 线程局部变量
 * @param baseMapper    基础数据操作接口
 */
public BaseServiceImpl(SimpleThreadContext<TokenInfo> threadContext, BaseMapper<E, F> baseMapper) {
	this.threadContext = threadContext;
	this.baseMapper = baseMapper;
}

@Override
public Response getBy(FilterPayload<E, F> payload) {
	// todo 校验 filter
	Map<String, Object> map = new HashMap<>();
	{
		List<E> _list = baseMapper.getBy(payload);
		map.put("data", _list);
		// todo 修改 sql 条件
		int count = baseMapper.getCountByFilter(payload);
		map.put("count", count);
	}
	return Response.success(map);
}

/**
 * 通过 id 获取实体数据
 *
 * @param payload 载体
 * @return 统一封装返回结果
 */
@Override
public Response getById(Payload<E> payload) {
	E _entity = baseMapper.getById(payload);
	if (_entity == null) {
		return Response.error(ResponseInfo.DATA_NOT_EXIST);
	}

	return Response.success(_entity);
}

@Override
public Response create(Payload<E> payload) {
	E _entity = payload.getEntity();
	if (_entity == null) {
		return Response.error(ResponseInfo.CREATE_DATA_ERROR);
	}
	{
		TokenInfo _info = threadContext.get();
		_entity.setCreatedBy(_info.getAud());
		_entity.setUpdatedBy(_info.getAud());
	}

	int _cc = baseMapper.insert(payload);
	if (_cc == 0) {
		return Response.error(ResponseInfo.CREATE_ERROR);
	}

	return Response.success();
}

@Override
@Transactional
public Response update(Payload<E> payload) {
	E _newEntity = payload.getEntity();
	if (_newEntity == null) {
		return Response.error(ResponseInfo.UPDATE_DATA_ERROR);
	}

	E _oldEntity = baseMapper.getToUpdate(payload);
	if (_oldEntity == null) {
		return Response.error(ResponseInfo.UPDATE_OLD_DATE_ERROR);
	}

	{
		TokenInfo _info = threadContext.get();
		_newEntity.setUpdatedBy(_info.getAud());
	}

	int _uc = baseMapper.update(payload);
	if (_uc == 0) {
		return Response.error(ResponseInfo.UPDATE_ERROR);
	}

	return Response.success(_oldEntity);
}

@Override
@Transactional
public Response delete(Payload<E> payload) {
	E _entity = baseMapper.getById(payload);
	if (_entity == null) {
		return Response.error(ResponseInfo.DATA_NOT_EXIST);
	}

	int _dc = baseMapper.delete(payload);
	if (_dc == 0) {
		return Response.error(ResponseInfo.DELETE_ERROR);
	}

	return Response.success(_entity);
}

}
