package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.utils.Jwt;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
   return Jwt.encoder(User.DEFAULT);
}
}
