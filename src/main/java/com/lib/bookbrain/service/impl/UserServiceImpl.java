package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.dao.UserMapper;
import com.lib.bookbrain.model.*;
import com.lib.bookbrain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
private final UserMapper userMapper;
private final BaseServiceImpl<User> baseService;

@Autowired
public UserServiceImpl(UserMapper userMapper) {
   this.userMapper = userMapper;
   baseService = new BaseServiceImpl<>(userMapper);
}


@Override
public Response login(Payload<User> payload) {
   boolean loginSuccess = userMapper.login(payload) == 1;
   if (loginSuccess) {
      return Response.success();
   }
   
   /* -------- 异常提示 -------- */
   return Response.error("用户ID或密码无效");
}
@AroundGet
@Override
public Response getBy(Payload<User> payload, Filter filter) {
   return baseService.getBy(payload, filter);
}


@Override
public Response create(Payload<User> payload) {
   return baseService.create(payload);
}

@AroundGet
@Override
public Response getById(Payload<User> payload) {
   return baseService.getById(payload);
}

@AroundUpdate
@Override
public Response update(Payload<User> payload) {
   return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Payload<User> payload) {
   // 获取
   User _user = userMapper.getById(payload);
   // 更新状态 => 已删除
   _user.updateState(User.State.IS_DELETE, User.Condition.ENABLE);
   //
   payload.setEntity(_user);
   
   return baseService.delete(payload);
}

}

