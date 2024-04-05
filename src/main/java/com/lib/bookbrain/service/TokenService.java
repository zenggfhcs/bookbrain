package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.exchange.Response;

public interface TokenService {
Response parse();

Response generate();

Response refresh();

TokenBody issue(Integer id, boolean refreshShort, boolean refreshLong);
}
