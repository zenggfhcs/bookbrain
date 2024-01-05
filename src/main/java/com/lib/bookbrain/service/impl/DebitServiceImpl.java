package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.annotation.AroundDelete;
import com.lib.bookbrain.annotation.AroundGet;
import com.lib.bookbrain.annotation.AroundUpdate;
import com.lib.bookbrain.dao.DebitMapper;
import com.lib.bookbrain.model.*;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public Response getBy(Payload<Debit> payload, Filter filter) {
   return baseService.getBy(payload, filter);
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
