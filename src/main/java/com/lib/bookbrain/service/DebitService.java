package com.lib.bookbrain.service;

import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.comm.filters.DebitFilter;
import com.lib.bookbrain.model.entity.Debit;

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
