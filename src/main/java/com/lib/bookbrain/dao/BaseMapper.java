package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.BaseEntity;
import com.lib.bookbrain.model.Payload;

import java.util.List;

/**
 * 基础 mapper
 *
 * @author yunxia
 */
public interface BaseMapper<T extends BaseEntity> {

T getById(Payload<T> payload);


List<T> getBy(Payload<T> payload);


int update(Payload<T> payload);


int insert(Payload<T> payload);

int delete(Payload<T> payload);

T getByUpdate(Payload<T> payload);
}
