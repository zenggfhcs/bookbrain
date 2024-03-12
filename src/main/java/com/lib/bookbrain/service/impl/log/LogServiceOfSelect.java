package com.lib.bookbrain.service.impl.log;


import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.LogMapper;
import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.LogFilter;
import com.lib.bookbrain.pojo.TokenInfo;
import com.lib.bookbrain.service.LogService;
import com.lib.bookbrain.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LogServiceOfSelect implements LogService {

private final LogMapper logMapper;
private final BaseServiceImpl<Log, LogFilter> baseService;

public LogServiceOfSelect(SimpleThreadContext<TokenInfo> threadContext, LogMapper logMapper) {
	this.logMapper = logMapper;
	baseService = new BaseServiceImpl<>(threadContext, logMapper);
}


public void Log(Log Log) {
	Payload<Log> ignorePayload = Payload.generateByEntity(Log);
	// mapper.insert
}

@Override
public Response getBy(FilterPayload<Log, LogFilter> payload) {
	return baseService.getBy(payload);
}

@Override
public Response create(Payload<Log> payload) {
	return null;
}

@Override
public Response getById(Payload<Log> payload) {
	return baseService.getById(payload);
}

@Override
public Response update(Payload<Log> payload) {
	return null;
}

@Override
public Response delete(Payload<Log> payload) {
	return null;
}
}
