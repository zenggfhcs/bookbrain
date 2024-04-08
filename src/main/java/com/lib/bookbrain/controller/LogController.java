package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.Log;
import com.lib.bookbrain.model.filter.LogFilter;
import com.lib.bookbrain.service.LogService;
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
public class LogController extends BaseController<Log, LogFilter> {

private final LogService logService;

public LogController(LogService logService) {
	super(logService);
	this.logService = logService;
}

}
