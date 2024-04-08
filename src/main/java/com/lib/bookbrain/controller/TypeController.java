package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.exchange.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/type")
public class TypeController {

@PostMapping("/bookType")
public Response bookType(@RequestParam String key) {
	return Response.success();
}
}
