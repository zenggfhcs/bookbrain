package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.DebitMapper;
import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.pojo.TokenInfo;
import com.lib.bookbrain.dto.filter.DebitFilter;
import com.lib.bookbrain.entity.Debit;
import com.lib.bookbrain.service.DebitService;
import org.springframework.stereotype.Service;

/**
 * @author yunxia
 */
@Service
public class DebitServiceImpl implements DebitService {

private final DebitMapper debitMapper;

private final BaseServiceImpl<Debit, DebitFilter> baseService;

public DebitServiceImpl(DebitMapper debitMapper, SimpleThreadContext<TokenInfo> threadContext) {
	this.debitMapper = debitMapper;
	baseService = new BaseServiceImpl<>(threadContext, debitMapper);
}

@AroundGet
@Override
public Response getBy(FilterPayload<Debit, DebitFilter> payload) {
	return baseService.getBy(payload);
}

@Override
public Response create(Payload<Debit> payload) {
	return baseService.create(payload);
}

@AroundGet
@Override
public Response getById(Payload<Debit> payload) {
	return baseService.getById(payload);
}

@AroundUpdate
@Override
public Response update(Payload<Debit> payload) {
	return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Payload<Debit> payload) {
	return baseService.delete(payload);
}
}
