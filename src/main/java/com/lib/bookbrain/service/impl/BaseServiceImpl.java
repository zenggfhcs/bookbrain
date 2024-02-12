package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.constant.Message;
import com.lib.bookbrain.dao.BaseMapper;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
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
   List<T> _list = baseMapper.getBy(payload);   // 查询
   return Response.success(_list);
}

@Override
public Response getById(Payload<T> payload) {
   T _t = baseMapper.getById(payload);          // 查询
   if (_t == null) {                            // 没有获取到信息
      return Response.error(Message.GET_ERROR); // 返回错误
   }
   payload.setEntity(_t);
   return Response.success(_t);                 // 返回查询到的数据
}

@Override
public Response create(Payload<T> payload) {
   if (payload.getEntity() == null) {                    // 需要创建的数据是空的
      return Response.error(Message.CREATE_DATA_ERROR);  // 返回错误
   }
   
   // todo 此处没有对数据完整性进行校验，如果出现错误会抛出异常
   int _cc = baseMapper.insert(payload);                 // 创建数据
   if (_cc == 0) {                                       // 创建失败
      return Response.error(Message.CREATE_ERROR);       // 返回错误
   }
   return Response.success();                            // 返回成功
}

@Override
@Transactional
public Response update(Payload<T> payload) {
   T _newEntityData = payload.getEntity();                  // 获取用来更新的数据
   if (_newEntityData == null) {                            // 用来更新的数据是空的
      return Response.error(Message.UPDATE_DATA_ERROR);     // 返回错误
   }
   T _oldEntityData = baseMapper.getToUpdate(payload);      // 获取需要被更新数据
   if (_oldEntityData == null) {                            // 需要被更新的数据不存在
      return Response.error(Message.UPDATE_OLD_DATE_ERROR); // 返回错误
   }
   _newEntityData.setRevision(_oldEntityData.getRevision());// 使用旧数据的版本号设置新数据的版本号（乐观锁），更新时使用
   int _uc = baseMapper.update(payload);                    // 更新
   // payload.setEntity(_newEntityData);                    // 记录新数据
   if (_uc == 0) {                                          // 未知原因更新失败
      return Response.error(Message.UPDATE_ERROR);          // 返回错误
   }
   return Response.success(_oldEntityData);                 // 返回成功
}


@Override
@Transactional
public Response delete(Payload<T> payload) {
   T _entity = baseMapper.getById(payload);              // 获取需要删除的对象
   if (_entity == null) {                                // 没有找到这个对象
      return Response.error(Message.DELETE_DATA_ERROR);  // 返回错误
   }
   int _dc = baseMapper.delete(payload);                 // 找到了，删除它
   if (_dc == 0) {                                       // 未知原因删除失败
      return Response.error(Message.DELETE_ERROR);       // 返回错误
   }
   
   return Response.success(_entity);                     // 返回成功
}

}
