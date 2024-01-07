package com.lib.bookbrain.service;

import com.lib.bookbrain.exception.MissPermissionException;
import com.lib.bookbrain.model.*;
import com.lib.bookbrain.model.entity.BaseEntity;

public interface BaseService<T extends BaseEntity> {
Response getBy(Payload<T> payload) throws MissPermissionException;

Response create(Payload<T> payload) throws MissPermissionException;

Response getById(Payload<T> payload);

Response update(Payload<T> payload);

Response delete(Payload<T> payload);
}
