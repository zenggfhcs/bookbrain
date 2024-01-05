package com.lib.bookbrain.service.impl;

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
      return Response.error("不存在");
   }
   return Response.success(_t);
}

@Override
public Response create(Payload<T> payload) {
   if (payload.getEntity() == null) {
      return Response.error("需要新建的 xx 信息为空");
   }
   
   int _cc = baseMapper.create(payload);
   
   if (_cc == 0) {
      return Response.error("新建失败");
   }
   return Response.success();
}

@Override
public Response update(Payload<T> payload) {
   // 新数据
   T _newEntityData = payload.getEntity();
   // 空数据处理
   if (_newEntityData == null) {
      return Response.error("更新数据为空");
   }
   // 获取原始数据
   T _oldEntityData = baseMapper.getByUpdate(payload);
   // 空数据处理
   if (_oldEntityData == null) {
      return Response.error("旧数据异常");
   }
   // 设置版本号（乐观锁）
   _newEntityData.setRevision(_oldEntityData.getRevision());
   // 更新
   int _uc = baseMapper.update(payload);
   // old replace new
   payload.setEntity(_newEntityData);
   // 判断结果
   if (_uc == 0) {
      return Response.error("更新失败");
   }
   return Response.success();
}


@Override
public Response delete(Payload<T> payload) {
   T _entity = baseMapper.getById(payload);
   if (_entity == null) {
      return Response.error("该 id 不存在对应的 publisher");
   }
   int _dc = baseMapper.delete(payload);
   if (_dc == 0) {
      return Response.error("删除失败");
   }
   payload.setEntity(_entity);
   return Response.success();
}
}
