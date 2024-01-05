package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.dao.UpdatedLogMapper;
import com.lib.bookbrain.model.Filter;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.log.UpdatedLog;
import com.lib.bookbrain.service.UpdateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateLogServiceImpl implements UpdateLogService {

private final UpdatedLogMapper updatedLogMapper;
private final BaseServiceImpl<UpdatedLog> baseService;

@Autowired
public UpdateLogServiceImpl(UpdatedLogMapper updatedLogMapper) {
   this.updatedLogMapper = updatedLogMapper;
   baseService = new BaseServiceImpl<>(updatedLogMapper);
}

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Override
public void createLog(UpdatedLog log) {
   Payload<UpdatedLog> _payload = new Payload<>();
   _payload.setEntity(log);
   this.create(_payload);
}

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Override
public void updateLog(UpdatedLog log) {
   Payload<UpdatedLog> _payload = new Payload<>();
   _payload.setEntity(log);
   this.update(_payload);
}

@Override
public Response getBy(Payload<UpdatedLog> payload, Filter filter) {
   return baseService.getBy(payload, filter);
}

@Override
public Response create(Payload<UpdatedLog> payload) {
   return baseService.create(payload);
}

@Override
public Response getById(Payload<UpdatedLog> payload) {
   return baseService.getById(payload);
}

@Override
public Response update(Payload<UpdatedLog> payload) {
   return baseService.update(payload);
}

@Override
public Response delete(Payload<UpdatedLog> payload) {
   return baseService.delete(payload);
}
}
