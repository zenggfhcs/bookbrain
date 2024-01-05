package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.Filter;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;

public interface DebitService extends BaseService<Debit> {
@Override
Response getBy(Payload<Debit> payload, Filter filter);

@Override
Response create(Payload<Debit> payload);

@Override
Response getById(Payload<Debit> payload);

@Override
Response update(Payload<Debit> payload);

@Override
Response delete(Payload<Debit> payload);
}
