package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.BaseFilter;
import com.lib.bookbrain.model.entity.Entity;

import java.util.List;

/**
 * 基础 mapper
 *
 * @author yunxia
 */
public interface BaseMapper<E extends Entity, F extends BaseFilter> {
E getById(Payload<E> payload);

List<E> getBy(FilterPayload<E, F> payload);

int update(Payload<E> payload);

int insert(Payload<E> payload);

int delete(Payload<E> payload);

E getToUpdate(Payload<E> payload);

int getCountByFilter(F filter);
}
