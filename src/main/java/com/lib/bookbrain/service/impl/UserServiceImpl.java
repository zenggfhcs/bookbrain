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
import com.lib.bookbrain.model.comm.TokenInfo;
import com.lib.bookbrain.model.comm.filters.UserFilter;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.service.UserService;
import com.lib.bookbrain.utils.RSATools;
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
public UserServiceImpl(UserMapper userMapper, SimpleThreadContext<TokenInfo> threadContext) {
	this.userMapper = userMapper;
	baseService = new BaseServiceImpl<>(threadContext, userMapper);
}

@Override
public Response register(Payload<User> payload) {
	// 解密
	User _entity = payload.getEntity();
	{
		_entity.setEmail(RSATools.decrypt(_entity.getEmail()));
		_entity.setAuthenticationString(RSATools.decrypt(_entity.getAuthenticationString()));
	}

	// 判断是不是重复注册
	if (userMapper.getByEmail(_entity.getEmail()) > 0) {
		return Response.error(ResponseInfo.THIS_EMAIL_IS_EXIST);
	}
	int _cc = userMapper.register(payload);

	// 判断注册插入是否成功
	if (_cc != 1) {
		return Response.error(ResponseInfo.REGISTER_FIELD);
	}

	// 成功之后，发送邮件 todo


	return Response.success();
}

@Override
public Response login(Payload<User> payload) {
	User _user = userMapper.login(payload);
	if (_user == null) {
		return Response.error(ResponseInfo.ID_OR_PASSWORD_FAILED);
	}
	return Response.success();
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
