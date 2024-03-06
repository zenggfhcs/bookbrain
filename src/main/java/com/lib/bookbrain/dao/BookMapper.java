package com.lib.bookbrain.dao;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.filter.BookFilter;
import com.lib.bookbrain.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * book mapper
 *
 * @author yunxia
 */
@Mapper
public interface BookMapper extends BaseMapper<Book, BookFilter> {
/* ============================ 继承 ============================ */
Book getById(Payload<Book> payload);

List<Book> getBy(FilterPayload<Book, BookFilter> payload);

int insert(Payload<Book> payload);

int update(Payload<Book> payload);

int delete(Payload<Book> payload);

Book getToUpdate(Payload<Book> payload);
/* ============================ 继承 ============================ */

}
