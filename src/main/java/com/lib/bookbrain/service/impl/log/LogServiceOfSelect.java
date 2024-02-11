package com.lib.bookbrain.service.impl.log;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceOfSelect implements LogService {

public void log(Log log) {
   Payload<Log> _payload = Payload.generateByEntity(log);
   // mapper.insert
}

@Override
public Response getBy(Payload<Log> payload) {
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
