package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.dto.filter.LogFilter;
import com.lib.bookbrain.entity.Log;
import com.lib.bookbrain.service.LogService;
import org.springframework.web.bind.annotation.PostMapping;
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

@PostMapping("/list/select")
public Response getLogs(@RequestBody(required = false) FilterPayload<Log, LogFilter> payload) {
	return logService.getBy(payload);
}
}
