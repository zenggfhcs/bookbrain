package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users:logout")
public class LogoutController {

private final UserService userService;

public LogoutController(UserService userService) {
	this.userService = userService;
}

@PostMapping
public Response logout() {
	return userService.logout();
}

}
