package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/login")
public class LoginController {
@PostMapping
public Response login(@RequestBody(required = false) Payload<User> payload) {
   return Response.success();
}
}