package com.lib.bookbrain.service.impl.log;

import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceOfSelect implements LogService {

public void log(Log log) {
   Payload<Log> ignorePayload = Payload.generateByEntity(log);
   // mapper.insert
}

@Override
public Response getBy(FilterPayload payload) {
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
