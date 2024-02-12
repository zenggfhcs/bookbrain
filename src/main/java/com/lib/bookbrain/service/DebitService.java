package com.lib.bookbrain.service;

import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.entity.Debit;

public interface DebitService extends BaseService<Debit> {
@Override
Response getBy(Payload<Debit> payload);

@Override
Response create(Payload<Debit> payload);

@Override
Response getById(Payload<Debit> payload);

@Override
Response update(Payload<Debit> payload);

@Override
Response delete(Payload<Debit> payload);
}
