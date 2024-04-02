package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface DebitService extends BaseService<Debit> {

@Override
Response create(Debit entity);

@Override
Response getById(Integer id);

@Override
Response update(Payload<Debit> payload);

@Override
Response delete(Integer id);
}
