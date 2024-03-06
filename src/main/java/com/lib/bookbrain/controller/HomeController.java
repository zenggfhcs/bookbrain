package com.lib.bookbrain.controller;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.filter.UserFilter;
import com.lib.bookbrain.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
@PostMapping
public Object test(@RequestBody FilterPayload<User, UserFilter> payload) {
	return "a";
}

}
