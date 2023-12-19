package com.lib.service.impl;

import com.lib.anno.AroundDelete;
import com.lib.anno.AroundGet;
import com.lib.anno.AroundUpdate;
import com.lib.dao.DebitMapper;
import com.lib.model.*;
import com.lib.service.DebitService;
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
