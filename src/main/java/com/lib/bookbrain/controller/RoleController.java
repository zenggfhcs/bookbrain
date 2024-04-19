package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.Role;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.RoleFilter;
import com.lib.bookbrain.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController extends BaseController<Role, RoleFilter> {
private final RoleService roleService;

public RoleController(RoleService roleService) {
	super(roleService);
	this.roleService = roleService;
}

@GetMapping("/tokenRole")
public Response tokenRole() {
	return roleService.tokenRole();
}
}
