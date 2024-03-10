package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface TokenService {
Response parse(Payload<TokenBody> payload);

Response generate(Payload<TokenBody> payload);
}
