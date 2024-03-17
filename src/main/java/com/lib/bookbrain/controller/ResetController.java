package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/reset")
public class ResetController {
/**
 * 重置密码
 *
 * @return 重置结果
 */
@PostMapping("/password")
public Response resetPassword() {
	return Response.success();
}

@PostMapping("/")
public Response sendCode(Payload<TokenBody> payload) {
	return Response.success();
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
