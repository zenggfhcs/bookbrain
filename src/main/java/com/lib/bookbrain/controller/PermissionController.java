package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.Permission;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.PermissionFilter;
import com.lib.bookbrain.service.PermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permissions")
public class PermissionController extends BaseController<Permission, PermissionFilter> {
private final PermissionService permissionService;

public PermissionController(PermissionService permissionService) {
	super(permissionService);
	this.permissionService = permissionService;
}

@GetMapping("/tokenPermission")
public Response tokenPermission() {
	return permissionService.tokenPermission();
}
}
