package com.lib.dao;

import com.lib.model.BaseEntity;
import com.lib.model.Filter;
import com.lib.model.Payload;

import java.util.List;

public interface BaseMapper<T extends BaseEntity> {

T getById(Payload<T> payload);


List<T> getBy(Payload<T> payload, Filter filter);


int update(Payload<T> payload);


int create(Payload<T> payload);

int delete(Payload<T> payload);

T getByUpdate(Payload<T> payload);
}
