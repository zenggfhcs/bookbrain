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
 * @author yunxia
 */
public class BaseServiceImpl<T extends BaseEntity, F extends Filter> implements BaseService<T, F> {
protected final SimpleThreadContext<TokenBody> threadContext;
protected final BaseMapper<T, F> baseMapper;

public BaseServiceImpl(SimpleThreadContext<TokenBody> threadContext, BaseMapper<T, F> baseMapper) {
   this.threadContext = threadContext;
   this.baseMapper = baseMapper;
}


@Override


public Response getBy(FilterPayload<T, F> payload) {
   List<T> _list = baseMapper.getBy(payload);   // 查询
   return Response.success(_list);
}

@Override
public Response getById(Payload<T> payload) {
   T _t = baseMapper.getById(payload);          // 查询
   if (_t == null) {                            // 没有获取到信息
      return Response.error(ResponseInfo.GET_ERROR); // 返回错误
   }
   payload.setEntity(_t);
   return Response.success(_t);                 // 返回查询到的数据
}

@Override
public Response create(Payload<T> payload) {
   T entity = payload.getEntity();
   if (entity == null) {                                 // 需要创建的数据是空的
      return Response.error(ResponseInfo.CREATE_DATA_ERROR);  // 返回错误
   }
   {                                                     // 设置操作者
      TokenBody body = threadContext.get();
      entity.setCreatedBy(body.getId());
      entity.setUpdatedBy(body.getId());
   }
   
   // todo 此处没有对数据完整性进行校验，如果出现错误会抛出异常
   int _cc = baseMapper.insert(payload);                 // 创建数据
   if (_cc == 0) {                                       // 创建失败
      return Response.error(ResponseInfo.CREATE_ERROR);
   }
   return Response.success();                            // 返回成功
}

@Override
@Transactional
public Response update(Payload<T> payload) {
   T _newEntity = payload.getEntity();                      // 获取用来更新的数据
   if (_newEntity == null) {                                // 用来更新的数据是空的
      return Response.error(ResponseInfo.UPDATE_DATA_ERROR);     // 返回错误
   }
   
   T _oldEntity = baseMapper.getToUpdate(payload);          // 获取需要被更新数据
   if (_oldEntity == null) {                                // 需要被更新的数据不存在
      return Response.error(ResponseInfo.UPDATE_OLD_DATE_ERROR); // 返回错误
   }
   
   _newEntity.setRevision(_oldEntity.getRevision());        // 使用旧数据的版本号设置新数据的版本号（乐观锁），更新时使用
   {                                                        // 设置操作者
      TokenBody body = threadContext.get();
      _newEntity.setUpdatedBy(body.getId());
   }
   int _uc = baseMapper.update(payload);                    // 更新
   
   if (_uc == 0) {                                          // 未知原因更新失败
      return Response.error(ResponseInfo.UPDATE_ERROR);
   }
   return Response.success(_oldEntity);                     // 返回成功
}


@Override
@Transactional
public Response delete(Payload<T> payload) {
   T _entity = baseMapper.getById(payload);              // 获取需要删除的对象
   if (_entity == null) {                                // 没有找到这个对象
      return Response.error(ResponseInfo.DELETE_DATA_ERROR);  // 返回错误
   }
   int _dc = baseMapper.delete(payload);                 // 找到了，删除它
   if (_dc == 0) {                                       // 未知原因删除失败
      return Response.error(ResponseInfo.DELETE_ERROR);
   }
   
   return Response.success(_entity);                     // 返回成功
}

}
