package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.dao.GetLogMapper;
import com.lib.bookbrain.model.*;
import com.lib.bookbrain.service.GetLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetLogServiceImpl implements GetLogService {
private final GetLogMapper getLogMapper;
private final BaseServiceImpl<GetLog> baseService;

public GetLogServiceImpl(GetLogMapper getLogMapper) {
   this.getLogMapper = getLogMapper;
   baseService = new BaseServiceImpl<>(getLogMapper);
}

/**
 * 创建一个日志
 *
 * @param log 需要创建的日志
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Override
public void createLog(GetLog log) {
   Payload<GetLog> payload = new Payload<>();
   payload.setEntity(log);
   getLogMapper.create(payload);
   
}

/**
 * 更新一个日志，用于更新返回值和执行时间
 *
 * @param log 需要更新的日志
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Override
public void updateLog(GetLog log) {
   Payload<GetLog> payload = new Payload<>();
   payload.setEntity(log);
   
   getLogMapper.update(payload);
}

public Response getBy(Payload<GetLog> payload, Filter filter) {
   return baseService.getBy(payload, filter);
}

@Override
public Response create(Payload<GetLog> payload) {
   return baseService.create(payload);
}

@Override
public Response getById(Payload<GetLog> payload) {
   return baseService.getById(payload);
}

@Override
public Response update(Payload<GetLog> payload) {
   return baseService.update(payload);
}

@Override
public Response delete(Payload<GetLog> payload) {
   return baseService.delete(payload);
}
}
