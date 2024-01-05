package com.lib.bookbrain.controller;


import com.lib.bookbrain.annotation.AroundConduct;
import com.lib.bookbrain.model.*;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AroundConduct
public class UserController {

private final UserService userService;

@Autowired
public UserController(UserService userService) {
   this.userService = userService;
}

@PostMapping("/login")
public Response login(@RequestBody(required = false) Payload<User> payload, @RequestHeader("token") String token) {
   return userService.login(payload);
}

@GetMapping
public Response getUsers(@RequestBody(required = false) Payload<User> payload, @RequestHeader("token") String token, @RequestBody(required = false) Filter filter) {
   return userService.getBy(payload, filter);
}

@PostMapping
public Response createUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader("token") String token) {
   return userService.create(payload);
}

@GetMapping("/{id}")
public Response getUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return userService.getById(payload);
}

@PatchMapping("/{id}")
public Response updateUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return userService.update(payload);
}


@DeleteMapping("/{id}")
public Response deleteUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return userService.delete(payload);
}
}
