package com.lib.bookbrain.service.impl.log;


import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.LogMapper;
import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.LogService;
import com.lib.bookbrain.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LogServiceOfSelect implements LogService {

private final LogMapper logMapper;
private final BaseServiceImpl<Log> baseService;

public LogServiceOfSelect(SimpleThreadContext<TokenInfo> threadContext, LogMapper logMapper) {
	this.logMapper = logMapper;
	baseService = new BaseServiceImpl<>(threadContext, logMapper);
}


public void Log(Log Log) {
	Payload<Log> ignorePayload = Payload.generateByEntity(Log);
	// mapper.insert
}

@Override
public Response list() {
	return baseService.list();
}

@Override
public Response create(Log entity) {
	return null;
}

@Override
public Response getById(Integer id) {
	return baseService.getById(id);
}

@Override
public Response update(Payload<Log> payload) {
	return null;
}

@Override
public Response delete(Integer id) {
	return null;
}
}
