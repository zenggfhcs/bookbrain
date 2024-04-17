package com.lib.bookbrain.service.impl;


import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.LogMapper;
import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.LogFilter;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

private final LogMapper logMapper;
private final BaseServiceImpl<Log, LogFilter> baseService;

public LogServiceImpl(SimpleThreadContext<TokenInfo> threadContext, LogMapper logMapper) {
	this.logMapper = logMapper;
	baseService = new BaseServiceImpl<>(threadContext, logMapper);
}

@Override
public Response list() {
	return baseService.list();
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

@Override
public Response filteredList(FilterPayload<Log, LogFilter> payload) {
	return baseService.filteredList(payload);
}
}
