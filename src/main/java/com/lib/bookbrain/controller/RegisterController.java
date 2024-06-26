package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/users:register")
public class RegisterController {
private final UserService userService;

@PostMapping
public Response register(@RequestBody(required = false) User user) {
	Payload<User> _payload = Payload.fromEntity(user);
	return userService.register(_payload);
}
}
