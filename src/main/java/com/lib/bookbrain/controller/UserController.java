package com.lib.bookbrain.controller;


import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.constant.HeaderName;
import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.comm.filters.UserFilter;
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

@PostMapping("/list/select")
public Response getUsers(@RequestBody(required = false) FilterPayload<User, UserFilter> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken) {
   return userService.getBy(payload);
}

@PostMapping("/list/create")
public Response createUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken) {
   return userService.create(payload);
}

@PostMapping("/{ignoredId}/select")
public Response getUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken, @PathVariable Integer ignoredId) {
   return userService.getById(payload);
}

@PostMapping("/{ignoredId}/update")
public Response updateUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken, @PathVariable Integer ignoredId) {
   return userService.update(payload);
}

@PostMapping("/{ignoredId}/delete")
public Response deleteUser(@RequestBody(required = false) Payload<User> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken, @PathVariable Integer ignoredId) {
   return userService.delete(payload);
}
}
