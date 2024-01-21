package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/register")
public class RegisterController {
@PostMapping
public Response register() {
   return Response.success();
}
}
