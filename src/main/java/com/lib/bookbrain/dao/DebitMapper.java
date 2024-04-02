package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.exchange.Payload;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yunxia
 */
@Mapper
public interface DebitMapper extends BaseMapper<Debit> {
/* ============================ ============================ */
Debit getById(Payload<Debit> payload);

int insert(Debit entity);

int update(Payload<Debit> payload);

int delete(Integer id);

Debit getToUpdate(Payload<Debit> payload);
/* ============================ ============================ */

}
