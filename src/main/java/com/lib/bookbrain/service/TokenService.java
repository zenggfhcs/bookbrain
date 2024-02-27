package com.lib.bookbrain.service;

import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.entity.TokenBody;

public interface TokenService {
    Response parse(Payload<TokenBody> payload);

    Response generate(Payload<TokenBody> payload);
}
