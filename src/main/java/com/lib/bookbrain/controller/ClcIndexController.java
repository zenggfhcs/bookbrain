package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.filter.ClcIndexFilter;
import com.lib.bookbrain.model.entity.ClcIndex;
import com.lib.bookbrain.service.ClcIndexService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clcIndexes")
public class ClcIndexController extends BaseController<ClcIndex, ClcIndexFilter> {

private final ClcIndexService clcIndexService;

public ClcIndexController(ClcIndexService clcIndexService) {
	super(clcIndexService);
	this.clcIndexService = clcIndexService;
}
}
