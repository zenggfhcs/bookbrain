package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test token controller
 *
 * @author yunxia
 */

@RestController
@RequestMapping("/token")
public class TokenController {
@PostMapping
public String token(@RequestBody(required = false) Payload<User> payload) {
   return null;
}
}
