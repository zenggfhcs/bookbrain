package com.lib.bookbrain.service;

import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.entity.TokenBody;

public interface VerifyService {
	Response verify(Payload<TokenBody> payload);
}

