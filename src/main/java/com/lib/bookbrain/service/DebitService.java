package com.lib.service;

import com.lib.model.*;

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
