package com.lib.bookbrain.controller;

import com.lib.bookbrain.annotation.AroundConduct;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.log.GetLog;
import com.lib.bookbrain.service.GetLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
@AroundConduct
public class GetLogController {
private final GetLogService logService;

public GetLogController(GetLogService logService) {
   this.logService = logService;
}

@GetMapping
public Response getLogs(@RequestBody(required = false) Payload<GetLog> payload) {
   return logService.getBy(payload);
}
}
