package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface VerifyService {
	Response verify(Payload<TokenBody> payload);
}

