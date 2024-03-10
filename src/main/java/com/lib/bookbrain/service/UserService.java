package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.UserFilter;

public interface UserService extends BaseService<User, UserFilter> {
Response register(Payload<User> payload);

Response login(Payload<User> payload);

Response getBy(FilterPayload<User, UserFilter> payload);

Response create(Payload<User> payload);

Response getById(Payload<User> payload);

Response update(Payload<User> payload);

Response delete(Payload<User> payload);

Response logout(Payload<User> payload);

int check(Integer id, String url);
}
