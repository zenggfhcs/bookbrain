package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
public class LogoutController {

private final UserService userService;

public LogoutController(UserService userService) {
	this.userService = userService;
}

@PostMapping
public Response logout(@RequestBody Payload<User> payload) {
	return userService.logout(payload);
}

}
