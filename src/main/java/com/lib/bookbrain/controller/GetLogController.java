package com.lib.bookbrain.controller;

import com.lib.bookbrain.annotation.AroundConduct;
import com.lib.bookbrain.model.*;
import com.lib.bookbrain.model.log.GetLog;
import com.lib.bookbrain.service.GetLogService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
@AroundConduct
public class GetLogController {
private final GetLogService logService;

public GetLogController(GetLogService logService) {
   this.logService = logService;
}

@GetMapping
public Response getLogs(@RequestBody(required = false) Payload<GetLog> payload, @RequestHeader("token") String token, @RequestBody(required = false) Filter filter) {
   return logService.getBy(payload, filter);
}
}
