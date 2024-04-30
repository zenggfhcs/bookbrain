package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.UserFilter;

public interface UserService extends BaseService<User, UserFilter> {
Response register(Payload<User> payload);

Response login(User entity);

Response logout();

int checkPermission(Integer id, String url);

Response sendCode(User entity);

Response resetPasswordByForgot(User entity);

Response tokenUser();

Response sendResetLink(User entity);

Response resetPasswordByUpdate(User user);

Response todayActiveUserCount();

Response todayNewUserCount();

Response updateRole(User user);
}
