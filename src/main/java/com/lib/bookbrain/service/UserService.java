package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;

public interface UserService extends BaseService<User> {
Response register(Payload<User> payload);

Response login(User entity);

Response create(User entity);

Response getById(Integer id);

Response update(Payload<User> payload);

Response delete(Integer id);

Response logout(Payload<User> payload);

int checkPermission(Integer id, String url);

Response sendCode(User entity);

Response resetPassword(Payload<User> payload);
}
