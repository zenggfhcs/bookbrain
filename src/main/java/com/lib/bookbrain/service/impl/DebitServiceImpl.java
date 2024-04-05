package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.DebitMapper;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.DebitService;
import org.springframework.stereotype.Service;

/**
 * @author yunxia
 */
@Service
public class DebitServiceImpl implements DebitService {

private final DebitMapper debitMapper;

private final BaseServiceImpl<Debit> baseService;

public DebitServiceImpl(DebitMapper debitMapper, SimpleThreadContext<TokenInfo> threadContext) {
	this.debitMapper = debitMapper;
	baseService = new BaseServiceImpl<>(threadContext, debitMapper);
}

@Override
public Response list() {
	return baseService.list();
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
