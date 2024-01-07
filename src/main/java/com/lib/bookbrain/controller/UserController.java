package com.lib.bookbrain.controller;


import com.lib.bookbrain.annotation.AroundConduct;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * user controller
 *
 * @author yunxia
 */
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
public Response login(@RequestBody(required = false) Payload<User> payload, @RequestHeader("token") String ignoredToken) {
   return userService.login(payload);
}

@GetMapping
public Response getUsers(@RequestBody(required = false) Payload<User> payload) {
   return userService.getBy(payload);
}

@PostMapping
public Response createUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader("token") String ignoredToken) {
   return userService.create(payload);
}

@GetMapping("/{ignoredId}")
public Response getUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return userService.getById(payload);
}

@PatchMapping("/{ignoredId}")
public Response updateUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return userService.update(payload);
}

@DeleteMapping("/{ignoredId}")
public Response deleteUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return userService.delete(payload);
}
}
