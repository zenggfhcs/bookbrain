package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.dao.UserMapper;
import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.pojo.TokenInfo;
import com.lib.bookbrain.service.VerifyService;
import com.lib.bookbrain.utils.Base64Coder;
import com.lib.bookbrain.utils.Json;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VerifyServiceImpl implements VerifyService {

private final UserMapper userMapper;

@Override
public Response verify(Payload<TokenBody> payload) {
	String _token = payload.getEntity().getToken();

	String _json = Base64Coder.decode(_token);

	TokenInfo _info = Json.parse(_json, TokenInfo.class);
	System.out.println(_info);

	// 不进行伪造识别、重复验证
	{
		userMapper.verifyEmail(_info.getJti());
	}

	return Response.success();
}
}
