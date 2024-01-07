package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.annotation.AroundDelete;
import com.lib.bookbrain.annotation.AroundGet;
import com.lib.bookbrain.annotation.AroundUpdate;
import com.lib.bookbrain.constants.Authority;
import com.lib.bookbrain.constants.State;
import com.lib.bookbrain.constants.UserCondition;
import com.lib.bookbrain.dao.UserMapper;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.entity.User;
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
public Response getBy(Payload<User> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.USER_GET);
   return baseService.getBy(payload);
}


@Override
public Response create(Payload<User> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.USER_CREATE);
   return baseService.create(payload);
}

@AroundGet
@Override
public Response getById(Payload<User> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.USER_GET);
   return baseService.getById(payload);
}

@AroundUpdate
@Override
public Response update(Payload<User> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.USER_UPDATE);
   return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Payload<User> payload) {
   /* -------- 权限检查 -------- */
   User.checkAuthority(payload.getTokenBody(), Authority.USER_DELETE);
   // 获取
   User _user = userMapper.getById(payload);
   // 更新状态 => 已删除
   _user.updateCondition(UserCondition.IS_ENABLE, State.OFF);
   //
   payload.setEntity(_user);
   
   return baseService.delete(payload);
}

}

