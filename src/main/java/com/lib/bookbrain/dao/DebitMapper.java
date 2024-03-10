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
/* ============================ ============================ */
Debit getById(Payload<Debit> payload);

List<Debit> getBy(FilterPayload<Debit, DebitFilter> payload);

int getCountByFilter(DebitFilter filter);

int insert(Payload<Debit> payload);

int update(Payload<Debit> payload);

int delete(Payload<Debit> payload);

Debit getToUpdate(Payload<Debit> payload);
/* ============================ ============================ */

}
