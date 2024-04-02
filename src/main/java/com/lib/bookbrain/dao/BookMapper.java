package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.exchange.Payload;
import org.apache.ibatis.annotations.Mapper;

/**
 * Book mapper
 *
 * @author yunxia
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
/* ============================ 继承 ============================ */
Book getById(Payload<Book> payload);

int insert(Book entity);

int update(Payload<Book> payload);

int delete(Integer id);

Book getToUpdate(Payload<Book> payload);
/* ============================ 继承 ============================ */

}
