package com.lib.bookbrain.service;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.Response;
import com.lib.bookbrain.dto.filter.UserFilter;
import com.lib.bookbrain.entity.User;

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
