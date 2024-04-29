package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.RouteItem;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BaseFilter;
import com.lib.bookbrain.service.RouteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routes")
public class RouteController extends BaseController<RouteItem, BaseFilter> {
private final RouteService routeService;

public RouteController(RouteService routeService) {
	super(routeService);
	this.routeService = routeService;
}

@GetMapping("/firstLevel")
public Response getFirstLevel() {
	return routeService.getFirstLevel();
}
}
