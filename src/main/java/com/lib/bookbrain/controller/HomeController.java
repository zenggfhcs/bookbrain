package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.filters.UserFilter;
import com.lib.bookbrain.model.entity.User;
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
