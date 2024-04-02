package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


@RequestMapping(path = "/token:refresh", method = RequestMethod.POST)
public Response refresh(@RequestBody(required = false) Payload<TokenBody> payload) {
	return tokenService.refresh(payload);
}

}
