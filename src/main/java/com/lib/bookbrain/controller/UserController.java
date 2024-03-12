package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.constant.Header;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.UserFilter;
import com.lib.bookbrain.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * User controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/users")
@AroundConduct
public class UserController {

private final UserService userService;

public UserController(UserService userService) {
	this.userService = userService;
}

@PostMapping("/list/select")
public Response getUsers(@RequestBody(required = false) FilterPayload<User, UserFilter> payload,
                         @RequestHeader(Header.TOKEN) String ignoredToken) {
	return userService.getBy(payload);
}

@PostMapping("/list/create")
public Response createUser(@RequestBody(required = false) Payload<User> payload,
                           @RequestHeader(Header.TOKEN) String ignoredToken) {
	return userService.create(payload);
}

@PostMapping("/{id}/select")
public Response getUser(@RequestBody(required = false) Payload<User> payload,
                        @RequestHeader(Header.TOKEN) String ignoredToken, @PathVariable Integer id) {
	payload.setId(id);
	return userService.getById(payload);
}

@PostMapping("/{id}/update")
public Response updateUser(@RequestBody(required = false) Payload<User> payload,
                           @RequestHeader(Header.TOKEN) String ignoredToken, @PathVariable Integer id) {
	payload.setId(id);
	return userService.update(payload);
}

@PostMapping("/{id}/delete")
public Response deleteUser(@RequestBody(required = false) Payload<User> payload,
                           @RequestHeader(Header.TOKEN) String ignoredToken, @PathVariable Integer id) {
	payload.setId(id);
	return userService.delete(payload);
}
}
