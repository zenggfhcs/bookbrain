package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.pojo.TokenInfo;

public interface TokenService {
Response parse();

Response generate();

Response refresh();

TokenBody issue(Integer id, boolean refreshShort, boolean refreshLong);

String issue(TokenInfo tokenInfo);

Response verify(Payload<TokenBody> payload);

TokenInfo verify(String token);
}
