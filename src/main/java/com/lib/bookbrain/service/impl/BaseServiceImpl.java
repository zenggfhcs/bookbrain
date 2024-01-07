package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.constants.Message;
import com.lib.bookbrain.dao.BaseMapper;
import com.lib.bookbrain.exception.UpdateErrorException;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.entity.BaseEntity;
import com.lib.bookbrain.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yunxia
 */
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
protected final BaseMapper<T> baseMapper;

public BaseServiceImpl(BaseMapper<T> baseMapper) {
   this.baseMapper = baseMapper;
}


@Override
public Response getBy(Payload<T> payload) {
   List<T> _list = baseMapper.getBy(payload);
   return Response.success(_list);
}

@Override
public Response getById(Payload<T> payload) {
   T _t = baseMapper.getById(payload);
   if (_t == null) {
      return Response.error(Message.GET_ERROR);
   }
   return Response.success(_t);
}

@Override
public Response create(Payload<T> payload) {
   if (payload.getEntity() == null) {
      return Response.error(Message.CREATE_DATA_ERROR);
   }
   
   int _cc = baseMapper.create(payload);
   
   if (_cc == 0) {
      return Response.error(Message.CREATE_ERROR);
   }
   return Response.success();
}

@Override
@Transactional
public Response update(Payload<T> payload) {
   // 新数据
   T _newEntityData = payload.getEntity();
   
   if (_newEntityData == null) { // 用来更新的数据是空的
      return Response.error(Message.UPDATE_DATA_ERROR);
   }
   
   // 获取旧数据
   T _oldEntityData = baseMapper.getByUpdate(payload);
   
   if (_oldEntityData == null) { // 需要被更新的数据不存在
      return Response.error(Message.UPDATE_OLD_DATE_ERROR);
   }
   
   // 设置版本号（乐观锁）
   _newEntityData.setRevision(_oldEntityData.getRevision());
   // 更新
   int _uc = baseMapper.update(payload);
   // old replace new
   payload.setEntity(_newEntityData);
   
   if (_uc > 1) { // 异常更新了多条，抛出异常回滚
      throw new UpdateErrorException();
   }
   if (_uc == 0) { // 未知原因更新失败
      return Response.error(Message.UPDATE_ERROR);
   }
   
   return Response.success();
}


@Override
public Response delete(Payload<T> payload) {
   // 获取需要删除的对象
   T _entity = baseMapper.getById(payload);
   
   if (_entity == null) { // 没有找到这个对象
      return Response.error(Message.DELETE_DATA_ERROR);
   }
   // 找到了，删除它
   int _dc = baseMapper.delete(payload);
   
   if (_dc == 0) { // 未知原因删除失败
      return Response.error(Message.DELETE_ERROR);
   }
   // 将需要删除的对象绑定到 payload 中
   payload.setEntity(_entity);
   return Response.success();
}

}
