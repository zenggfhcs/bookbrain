package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.UserMapper;
import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.comm.TokenBody;
import com.lib.bookbrain.model.comm.filters.UserFilter;
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
private final BaseServiceImpl<User, UserFilter> baseService;

@Autowired
public UserServiceImpl(UserMapper userMapper, SimpleThreadContext<TokenBody> threadContext) {
   this.userMapper = userMapper;
   baseService = new BaseServiceImpl<>(threadContext, userMapper);
}


@Override
public Response login(Payload<User> payload) {
   User _user = userMapper.login(payload);            // 登录
   if (_user == null) {                               // 登录失败
      return Response.error(ResponseInfo.ID_OR_PASSWORD_FAILED);    // 返回登录失败
   }
   return Response.success();                         // 返回成功
}

@AroundGet
@Override
public Response getBy(FilterPayload<User, UserFilter> payload) {
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

