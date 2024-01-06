package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.constants.Message;
import com.lib.bookbrain.dao.BaseMapper;
import com.lib.bookbrain.model.*;
import com.lib.bookbrain.model.entity.BaseEntity;
import com.lib.bookbrain.service.BaseService;

import java.util.List;

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
public Response update(Payload<T> payload) {
   // 新数据
   T _newEntityData = payload.getEntity();
   // 空数据处理
   if (_newEntityData == null) {
      return Response.error(Message.UPDATE_DATA_ERROR);
   }
   // 获取原始数据
   T _oldEntityData = baseMapper.getByUpdate(payload);
   // 空数据处理
   if (_oldEntityData == null) {
      return Response.error(Message.UPDATE_OLD_DATE_ERROR);
   }
   // 设置版本号（乐观锁）
   _newEntityData.setRevision(_oldEntityData.getRevision());
   // 更新
   int _uc = baseMapper.update(payload);
   // old replace new
   payload.setEntity(_newEntityData);
   // 判断结果
   if (_uc == 0) {
      return Response.error(Message.UPDATE_ERROR);
   }
   return Response.success();
}


@Override
public Response delete(Payload<T> payload) {
   T _entity = baseMapper.getById(payload);
   if (_entity == null) {
      return Response.error(Message.DELETE_DATA_ERROR);
   }
   int _dc = baseMapper.delete(payload);
   if (_dc == 0) {
      return Response.error(Message.DELETE_ERROR);
   }
   payload.setEntity(_entity);
   return Response.success();
}
}
