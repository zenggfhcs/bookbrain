package com.lib.bookbrain.dao;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.filter.DebitFilter;
import com.lib.bookbrain.entity.Debit;
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

int insert(Payload<Debit> payload);

int update(Payload<Debit> payload);

int delete(Payload<Debit> payload);

Debit getToUpdate(Payload<Debit> payload);
/* ============================ ============================ */

}
