package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.annotation.AroundDelete;
import com.lib.bookbrain.annotation.AroundGet;
import com.lib.bookbrain.annotation.AroundUpdate;
import com.lib.bookbrain.constants.Message;
import com.lib.bookbrain.dao.UserMapper;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yunxia
 */
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
   int _lc = userMapper.login(payload);            // 登录
   if (_lc != 1) {                                 // 登录失败
      return Response.error(Message.LOGIN_FAILED); // 返回登录失败
   }
   return Response.success();                      // 返回成功
}

@AroundGet
@Override
public Response getBy(Payload<User> payload) {
   return baseService.getBy(payload);
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
   return baseService.delete(payload);
}

}

