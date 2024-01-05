package com.lib.bookbrain.service;

import com.lib.bookbrain.model.Filter;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.model.entity.User;

public interface UserService extends BaseService<User> {
Response login(Payload<User> payload);

Response getBy(Payload<User> payload, Filter filter);

Response create(Payload<User> payload);

Response getById(Payload<User> payload);

Response update(Payload<User> payload);

Response delete(Payload<User> payload);


}

