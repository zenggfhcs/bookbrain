package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.BaseEntity;
import com.lib.bookbrain.model.comm.Filter;
import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;

import java.util.List;

/**
 * 基础 mapper
 *
 * @author yunxia
 */
public interface BaseMapper<T extends BaseEntity, F extends Filter> {
T getById(Payload<T> payload);

List<T> getBy(FilterPayload<T, F> payload);

int update(Payload<T> payload);

int insert(Payload<T> payload);

int delete(Payload<T> payload);

T getToUpdate(Payload<T> payload);
}
