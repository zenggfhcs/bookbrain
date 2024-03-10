package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.constant.Header;
import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.LogFilter;
import com.lib.bookbrain.service.LogService;
import org.springframework.web.bind.annotation.*;

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

@PostMapping("/list/select")
public Response getLogs(@RequestBody(required = false) FilterPayload<Log, LogFilter> payload, @RequestHeader(Header.TOKEN) String ignoredToken) {
	return logService.getBy(payload);
}
}
