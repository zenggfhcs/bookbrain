package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * book mapper
 *
 * @author yunxia
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

Book getById(Payload<Book> payload);

List<Book> getBy(@Param("payload") Payload<Book> payload);

int insert(Payload<Book> payload);

int update(Payload<Book> payload);

int delete(Payload<Book> payload);

Book getByUpdate(Payload<Book> payload);
}
