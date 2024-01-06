package com.lib.bookbrain.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class TokenController {
@PostMapping("/token")
public String token() {
   return "token";
}
}
