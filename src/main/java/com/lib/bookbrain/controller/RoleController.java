package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.Role;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.RoleFilter;
import com.lib.bookbrain.service.RoleService;
import org.springframework.web.bind.annotation.*;

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

@PostMapping("/addPermission")
public Response addPermission(@RequestBody Role role) {
	Payload<Role> _payload = Payload.fromEntity(role);
	return roleService.addPermission(_payload);
}


@PostMapping("/removePermission")
public Response removePermission(@RequestBody Role role) {
	Payload<Role> _payload = Payload.fromEntity(role);
	return roleService.removePermission(_payload);
}

@PostMapping("/addRoute")
public Response addRoute(@RequestBody Role role) {
	Payload<Role> _payload = Payload.fromEntity(role);
	return roleService.addRoute(_payload);
}

@PostMapping("/removeRoute")
public Response removeRoute(@RequestBody Role role) {
	Payload<Role> _payload = Payload.fromEntity(role);
	return roleService.removeRoute(_payload);
}
}
