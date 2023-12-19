package com.lib.service.impl;

import com.lib.dao.DeletedLogMapper;
import com.lib.model.*;
import com.lib.service.DeleteLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteLogServiceImpl implements DeleteLogService {
private final DeletedLogMapper deletedLogMapper;
private final BaseServiceImpl<DeletedLog> baseService;

public DeleteLogServiceImpl(DeletedLogMapper deletedLogMapper) {
   this.deletedLogMapper = deletedLogMapper;
   baseService = new BaseServiceImpl<>(deletedLogMapper);
}


@Transactional(propagation = Propagation.REQUIRES_NEW)
@Override
public void createLog(DeletedLog log) {
   Payload<DeletedLog> _payload = new Payload<>();
   _payload.setEntity(log);
   deletedLogMapper.create(_payload);
}

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Override
public void updateLog(DeletedLog log) {
   Payload<DeletedLog> _payload = new Payload<>();
   _payload.setEntity(log);
   deletedLogMapper.update(_payload);
}

public Response getBy(Payload<DeletedLog> payload, Filter filter) {
   return baseService.getBy(payload, filter);
}


@Override
public Response create(Payload<DeletedLog> payload) {
   return baseService.create(payload);
}

@Override
public Response getById(Payload<DeletedLog> payload) {
   return baseService.getById(payload);
}

@Override
public Response update(Payload<DeletedLog> payload) {
   return baseService.update(payload);
}

@Override
public Response delete(Payload<DeletedLog> payload) {
   return baseService.delete(payload);
}
}
