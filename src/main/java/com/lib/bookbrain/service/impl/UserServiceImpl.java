package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.UserMapper;
import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.UserFilter;
import com.lib.bookbrain.pojo.TokenInfo;
import com.lib.bookbrain.service.MailService;
import com.lib.bookbrain.service.TokenService;
import com.lib.bookbrain.service.UserService;
import com.lib.bookbrain.utils.RSATools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yunxia
 */
@Service
public class UserServiceImpl implements UserService {

private final UserMapper userMapper;

private final BaseServiceImpl<User, UserFilter> baseService;

private final MailService mailService;

private final TokenService tokenService;

@Autowired
public UserServiceImpl(UserMapper userMapper, SimpleThreadContext<TokenInfo> threadContext, MailService mailService, TokenService tokenService) {
	this.userMapper = userMapper;
	baseService = new BaseServiceImpl<>(threadContext, userMapper);
	this.mailService = mailService;
	this.tokenService = tokenService;
}


@Override
public Response logout(Payload<User> payload) {
	// todo 退出登录逻辑，清除 token
	return Response.success();
}

@Override
public int checkPermission(Integer id, String url) {
	return userMapper.check(id, url);
}

@Override
public Response sendCode(Payload<User> payload) {
	mailService.sendCode(payload.getEntity(), "重置密码");
	return Response.success();
}

@Override
public Response resetPassword(Payload<User> payload) {
	// 解密
	User _entity = payload.getEntity();
	{
		_entity.setEmail(RSATools.decrypt(_entity.getEmail()));
		_entity.setAuthenticationString(RSATools.decrypt(_entity.getAuthenticationString()));
	}

	int _uc = userMapper.resetPassword(payload);

	if (_uc != 1) {
		return Response.error(ResponseInfo.ERROR);
	}

	return Response.success();
}

@Override
@Transactional
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

	// 先发送邮件再插入数据
	mailService.sendLink(_entity, "注册");

	{ // 插入数据
		userMapper.register(payload);
		userMapper.addUserRole(payload);
		userMapper.addUserCondition(payload);
	}

	return Response.success();
}

@Override
public Response login(Payload<User> payload) {
	User _user = userMapper.login(payload);

	if (_user == null) {
		return Response.error(ResponseInfo.ID_OR_PASSWORD_FAILED);
	}

	TokenBody _body = tokenService.issue(_user.getId(), true, true);

	return Response.success(_body);
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
