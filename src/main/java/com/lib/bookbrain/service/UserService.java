package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface UserService extends BaseService<User> {
Response register(Payload<User> payload);

Response login(User entity);

Response create(Payload<User> payload);

Response getById(Payload<User> payload);

Response update(Payload<User> payload);

Response delete(Payload<User> payload);

Response logout(Payload<User> payload);

int checkPermission(Integer id, String url);

Response sendCode(User entity);

Response resetPassword(User entity);
}
