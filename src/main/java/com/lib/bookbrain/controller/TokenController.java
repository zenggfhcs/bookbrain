package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
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
public Response token(@RequestBody(required = false) Payload<TokenBody> payload) {
	return null;
}

@PostMapping("/key")
public String rsaPublic() {
	return "";
}
}
