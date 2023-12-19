package com.lib.web.controller;

import com.lib.anno.AroundConduct;
import com.lib.model.*;
import com.lib.service.GetLogService;
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
