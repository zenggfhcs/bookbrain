package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.DebitFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yunxia
 */
@Mapper
public interface DebitMapper extends BaseMapper<Debit, DebitFilter> {
List<Debit> list();

Debit getById(Payload<Debit> payload);

int insert(Debit entity);

int update(Payload<Debit> payload);

int delete(Integer id);

Debit getToUpdate(Payload<Debit> payload);

List<Debit> filteredList(FilterPayload<Debit, DebitFilter> payload);

int getLengthByFilter(FilterPayload<Debit, DebitFilter> payload);
}
