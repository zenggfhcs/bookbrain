package com.lib.bookbrain.service;

import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.entity.TokenBody;

public interface TokenService {
Response parse(Payload<TokenBody> payload);

Response generate(Payload<TokenBody> payload);
}
