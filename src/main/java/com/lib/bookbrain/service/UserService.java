package com.lib.bookbrain.service;

import com.lib.bookbrain.model.dto.Payload;
import com.lib.bookbrain.model.dto.Response;
import com.lib.bookbrain.model.entity.User;

public interface UserService extends BaseService<User> {
Response login(Payload<User> payload);

Response getBy(Payload<User> payload);

Response create(Payload<User> payload);

Response getById(Payload<User> payload);

Response update(Payload<User> payload);

Response delete(Payload<User> payload);


}

