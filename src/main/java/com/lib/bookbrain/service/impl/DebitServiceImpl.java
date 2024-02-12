package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.dao.DebitMapper;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yunxia
 */
@Service
public class DebitServiceImpl implements DebitService {

private final DebitMapper debitMapper;
private final BaseServiceImpl<Debit> baseService;

@Autowired
public DebitServiceImpl(DebitMapper debitMapper) {
   this.debitMapper = debitMapper;
   baseService = new BaseServiceImpl<>(debitMapper);
}

@AroundGet
@Override
public Response getBy(Payload<Debit> payload) {
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
