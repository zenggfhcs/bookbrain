package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/users/reset")
public class ResetController {

private final UserService userService;

/**
 * 重置密码
 *
 * @return 重置结果
 */
@PostMapping("/password")
public Response resetPassword(@RequestBody Payload<User> payload) {
	return userService.resetPassword(payload);
}

/**
 * 重置用户名
 *
 * @return 重置结果
 */
@PostMapping("/username")
public Response resetUserName() {
	return Response.success();
}
}
