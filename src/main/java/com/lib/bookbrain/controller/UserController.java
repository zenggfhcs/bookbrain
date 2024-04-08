package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.TokenBody;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.UserFilter;
import com.lib.bookbrain.service.UploadService;
import com.lib.bookbrain.service.UserService;
import com.lib.bookbrain.service.VerifyService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * User controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/users")
@AroundConduct
public class UserController extends BaseController<User, UserFilter> {

private final UploadService uploadService;

private final VerifyService verifyService;

private final UserService userService;

public UserController(UploadService uploadService, VerifyService verifyService, UserService userService) {
	super(userService);
	this.uploadService = uploadService;
	this.verifyService = verifyService;
	this.userService = userService;
}

@PostMapping("/cover:upload")
public Response cover(@RequestParam MultipartFile file) {
	return uploadService.upload(file);
}

@PostMapping(path = "/email:verify")
public Response verify(@RequestBody Payload<TokenBody> payload) {
	return verifyService.verify(payload);
}


@PostMapping("/password:reset/email:sendCode")
public Response sendCodeForResetPassword(@RequestBody User entity) {
	return userService.sendCode(entity);
}

/**
 * 重置密码
 *
 * @return 重置结果
 */
@PostMapping("/password:reset")
public Response resetPassword(@RequestBody User entity) {
	return userService.resetPassword(entity);
}

/**
 * 重置用户名
 *
 * @return 重置结果
 */
@PostMapping("/username:reset")
public Response resetUserName() {
	return Response.success();
}

}
