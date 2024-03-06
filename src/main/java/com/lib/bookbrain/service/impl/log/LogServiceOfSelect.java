package com.lib.bookbrain.service.impl.log;


import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.dto.filter.LogFilter;
import com.lib.bookbrain.entity.Log;
import com.lib.bookbrain.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceOfSelect implements LogService {

public void log(Log log) {
	Payload<Log> ignorePayload = Payload.generateByEntity(log);
	// mapper.insert
}

@Override
public Response getBy(FilterPayload<Log, LogFilter> payload) {
	return null;
}

@Override
public Response create(Payload<Log> payload) {
	return null;
}

@Override
public Response getById(Payload<Log> payload) {
	return null;
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
