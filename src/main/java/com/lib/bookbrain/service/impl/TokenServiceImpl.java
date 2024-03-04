package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
@Override
public Response parse(Payload<TokenBody> payload) {
	TokenBody body = payload.getEntity();

	return null;
}

@Override
public Response generate(Payload<TokenBody> payload) {
	return null;
}
}
