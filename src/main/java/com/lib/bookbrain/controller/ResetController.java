package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ResetController {

private final UserService userService;

/**
 * 重置密码
 *
 * @return 重置结果
 */
@RequestMapping(path = "/users/password:reset", method = RequestMethod.POST)
public Response resetPassword(@RequestBody User entity) {
	return userService.resetPassword(entity);
}

/**
 * 重置用户名
 *
 * @return 重置结果
 */
@RequestMapping(path = "/users/username:reset", method = RequestMethod.POST)
public Response resetUserName() {
	return Response.success();
}
}
