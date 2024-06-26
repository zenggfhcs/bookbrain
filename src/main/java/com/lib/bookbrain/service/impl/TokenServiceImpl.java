package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.pojo.Token;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.security.Jwt;
import com.lib.bookbrain.service.TokenService;
import com.lib.bookbrain.utils.Json;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

private final long SHORT_TOKEN_VALIDITY_TIME;

private final long LONG_TOKEN_VALIDITY_TIME;

private final SimpleThreadContext<TokenInfo> threadContext;

public TokenServiceImpl(@Value("${token.validityTime.short}") Long shortTime, @Value("${token.validityTime.long}") Long longTime, SimpleThreadContext<TokenInfo> threadContext) {

	SHORT_TOKEN_VALIDITY_TIME = shortTime;
	LONG_TOKEN_VALIDITY_TIME = longTime;
	this.threadContext = threadContext;
}

@Override
public Response parse() {
	return null;
}

@Override
public Response generate() {
	return null;
}

private String refreshShortToken(Integer id) {
	return Jwt.encoder(id, SHORT_TOKEN_VALIDITY_TIME);
}

private String refreshLongToken(Integer id) {
	return Jwt.encoder(id, LONG_TOKEN_VALIDITY_TIME);
}

@Override
public Response refresh() {
	Integer _id = threadContext.get().getAud();
	// 默认会刷新 short token
	boolean _refreshShort = true;
	// 如果刷新 short token 后， long token 的有效期短于 short token，那就刷新 long token
	boolean _refreshLong = (threadContext.get().getExp() - SHORT_TOKEN_VALIDITY_TIME) < System.currentTimeMillis();

	return Response.success(this.issue(_id, _refreshShort, _refreshLong));
}

@Override
public TokenBody issue(Integer id, boolean refreshShort, boolean refreshLong) {
	TokenBody _body = new TokenBody();

	Token _token = new Token();

	if (refreshShort) {
		_token.setToken(refreshShortToken(id));
	}
	if (refreshLong) {
		_token.setRefreshToken(refreshLongToken(id));
	}

	_body.setToken(Json.stringify(_token));

	return _body;
}

@Override
public String issue(TokenInfo tokenInfo) {
	return Jwt.encoder(tokenInfo, SHORT_TOKEN_VALIDITY_TIME);
}

@Override
public Response verify(Payload<TokenBody> payload) {
	String _token = payload.getEntity().getToken();
	TokenInfo _info = Jwt.decoder(_token);
	User _u = User.fromTokenInfo(_info);
	return Response.success(_u);
}

@Override
public TokenInfo verify(String token) {
	return Jwt.decoder(token);
}

}
