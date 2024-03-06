package com.lib.bookbrain.dao;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.filter.BaseFilter;
import com.lib.bookbrain.entity.BaseEntity;

import java.util.List;

/**
 * 基础 mapper
 *
 * @author yunxia
 */
public interface BaseMapper<T extends BaseEntity, F extends BaseFilter> {
T getById(Payload<T> payload);

List<T> getBy(FilterPayload<T, F> payload);

int update(Payload<T> payload);

int insert(Payload<T> payload);

int delete(Payload<T> payload);

T getToUpdate(Payload<T> payload);
}
