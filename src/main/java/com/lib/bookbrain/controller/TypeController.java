package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.exchange.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type")
public class TypeController {

@PostMapping("/bookType")
public Response bookType(@RequestParam String key) {
	return Response.success();
}
}
