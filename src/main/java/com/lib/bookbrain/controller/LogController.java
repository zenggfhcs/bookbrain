package com.lib.bookbrain.controller;

import com.lib.bookbrain.annotation.AroundConduct;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.service.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * log controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/logs")
@AroundConduct
public class LogController {
private final LogService logService;

public LogController(LogService logService) {
   this.logService = logService;
}

@GetMapping
public Response getLogs(@RequestBody(required = false) Payload<Log> payload) {
   return logService.getBy(payload);
}
}