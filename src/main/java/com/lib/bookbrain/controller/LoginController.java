package com.lib.bookbrain.controller;

import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.entity.User;
import com.lib.bookbrain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

private final UserService userService;

@PostMapping
public Response login(@RequestBody(required = false) Payload<User> payload) {
	return userService.login(payload);
}
}
