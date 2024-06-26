package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * test token controller
 *
 * @author yunxia
 */

@RestController
@AllArgsConstructor
public class TokenController {

private final TokenService tokenService;


@PostMapping("/token:refresh")
public Response refresh() {
	return tokenService.refresh();
}

@PostMapping("/token:verify")
public Response verify(@RequestBody TokenBody tokenBody) {
	Payload<TokenBody> _payload = Payload.fromEntity(tokenBody);
	return tokenService.verify(_payload);
}

}
