package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.VerifyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verify")
public class VerifyController {

private final VerifyService verifyService;

public VerifyController(VerifyService verifyService) {
	this.verifyService = verifyService;
}

@PostMapping
public Response verify(@RequestBody Payload<TokenBody> payload) {
	return verifyService.verify(payload);
}
}
