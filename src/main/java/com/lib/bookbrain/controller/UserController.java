package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/users")
@AroundConduct
public class UserController extends BaseController<User> {

private final UserService userService;

public UserController(UserService userService) {
	super(userService);
	this.userService = userService;
}

@PostMapping("/password:reset/email:sendCode")
public Response sendCodeForResetPassword(@RequestBody User entity) {
	return userService.sendCode(entity);
}

}
