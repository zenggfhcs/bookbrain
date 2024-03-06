package com.lib.bookbrain.service;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.dto.filter.DebitFilter;
import com.lib.bookbrain.entity.Debit;

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
