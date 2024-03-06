package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.entity.TokenBody;
import com.lib.bookbrain.pojo.TokenInfo;
import com.lib.bookbrain.service.VerifyService;
import com.lib.bookbrain.utils.Base64Coder;
import com.lib.bookbrain.utils.Json;
import org.springframework.stereotype.Service;

@Service
public class VerifyServiceImpl implements VerifyService {

@Override
public Response verify(Payload<TokenBody> payload) {
	String _token = payload.getEntity().getToken();

	String _json = Base64Coder.decode(_token);

	TokenInfo _info = Json.parse(_json, TokenInfo.class);
	System.out.println(_info);

	// todo 重复验证检查

	// todo 怎么防伪造，伪造会导致什么后果

	// todo 进行验证
	{

	}


	return Response.success();
}
}
