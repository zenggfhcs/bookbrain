package com.lib.bookbrain.service;

import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.comm.filters.UserFilter;
import com.lib.bookbrain.model.entity.User;

public interface UserService extends BaseService<User, UserFilter> {
Response login(Payload<User> payload);

Response getBy(FilterPayload<User, UserFilter> payload);

Response create(Payload<User> payload);

Response getById(Payload<User> payload);

Response update(Payload<User> payload);

Response delete(Payload<User> payload);


}

