package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BaseMapper;
import com.lib.bookbrain.model.BaseEntity;
import com.lib.bookbrain.model.comm.*;
import com.lib.bookbrain.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * BaseService 的实现类
 * <br>为所有实现 BaseService 的类提供一个默认实现，
 * 通过使用这个默认实现，统一操作逻辑
 *
 * @author yunxia
 */
public class BaseServiceImpl<T extends BaseEntity, F extends Filter> implements BaseService<T, F> {

/**
 * 线程共享的 tokenBody 对象，用于存放操作人信息
 */
protected final SimpleThreadContext<TokenBody> threadContext;

/**
 * baseMapper
 * <br>实际使用时会被他的子接口替换
 */
protected final BaseMapper<T, F> baseMapper;

/**
 * 自动注入
 *
 * @param threadContext tokenBody 线程局部变量
 * @param baseMapper    基础数据操作接口
 */
public BaseServiceImpl(SimpleThreadContext<TokenBody> threadContext, BaseMapper<T, F> baseMapper) {
   this.threadContext = threadContext;
   this.baseMapper = baseMapper;
}


@Override
public Response getBy(FilterPayload<T, F> payload) {
   List<T> _list = baseMapper.getBy(payload);
   return Response.success(_list);
}

/**
 * 通过 id 获取实体数据
 *
 * @param payload 载体
 * @return 统一封装返回结果
 */
@Override
public Response getById(Payload<T> payload) {
   T _entity = baseMapper.getById(payload);
   if (_entity == null) {
      return Response.error(ResponseInfo.DATA_NOT_EXIST);
   }
   
   return Response.success(_entity);
}

@Override
public Response create(Payload<T> payload) {
   T _entity = payload.getEntity();
   if (_entity == null) {
      return Response.error(ResponseInfo.CREATE_DATA_ERROR);
   }
   {
      TokenBody _body = threadContext.get();
      _entity.setCreatedBy(_body.getId());
      _entity.setUpdatedBy(_body.getId());
   }
   
   int _cc = baseMapper.insert(payload);
   if (_cc == 0) {
      return Response.error(ResponseInfo.CREATE_ERROR);
   }
   
   return Response.success();
}

@Override
@Transactional
public Response update(Payload<T> payload) {
   T _newEntity = payload.getEntity();
   if (_newEntity == null) {
      return Response.error(ResponseInfo.UPDATE_DATA_ERROR);
   }
   
   T _oldEntity = baseMapper.getToUpdate(payload);
   if (_oldEntity == null) {
      return Response.error(ResponseInfo.UPDATE_OLD_DATE_ERROR);
   }
   
   _newEntity.setRevision(_oldEntity.getRevision());
   {
      TokenBody body = threadContext.get();
      _newEntity.setUpdatedBy(body.getId());
   }
   
   int _uc = baseMapper.update(payload);
   if (_uc == 0) {
      return Response.error(ResponseInfo.UPDATE_ERROR);
   }
   
   return Response.success(_oldEntity);
}


@Override
@Transactional
public Response delete(Payload<T> payload) {
   T _entity = baseMapper.getById(payload);
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
