package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.DebitFilter;

public interface DebitService extends BaseService<Debit, DebitFilter> {
@Override
Response getBy(FilterPayload<Debit, DebitFilter> payload);

@Override
Response create(Payload<Debit> payload);

@Override
Response getById(Payload<Debit> payload);

@Override
Response update(Payload<Debit> payload);

@Override
Response delete(Payload<Debit> payload);
}
