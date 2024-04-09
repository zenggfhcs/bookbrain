package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.Entity;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.BaseFilter;

import java.util.List;

/**
 * 基础 mapper
 *
 * @author yunxia
 */
public interface BaseMapper<E extends Entity, F extends BaseFilter> {
List<E> list();

int count();

E getById(Integer id);

int update(Payload<E> payload);

int insert(E entity);

int delete(Integer id);

E getToUpdate(Payload<E> payload);

List<E> filteredList(FilterPayload<E, F> payload);

int getLengthByFilter(FilterPayload<E, F> payload);
}
