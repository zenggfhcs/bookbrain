package com.lib.service;

import com.lib.model.*;

public interface UserService extends BaseService<User> {
Response login(Payload<User> payload);

Response getBy(Payload<User> payload, Filter filter);

Response create(Payload<User> payload);

Response getById(Payload<User> payload);

Response update(Payload<User> payload);

Response delete(Payload<User> payload);


}

