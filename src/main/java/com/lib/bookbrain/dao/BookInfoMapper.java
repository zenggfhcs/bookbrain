package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.BookInfoFilter;
import com.lib.bookbrain.model.entity.BookInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * book info mapper
 *
 * @author yunxia
 */
@Mapper
public interface BookInfoMapper extends BaseMapper<BookInfo, BookInfoFilter> {
/* ============================ 继承 ============================ */
BookInfo getById(Payload<BookInfo> payload);

List<BookInfo> getBy(FilterPayload<BookInfo, BookInfoFilter> payload);

int getCountByFilter(BookInfoFilter filter);

int update(Payload<BookInfo> payload);

int insert(Payload<BookInfo> payload);

int delete(Payload<BookInfo> payload);

BookInfo getToUpdate(Payload<BookInfo> payload);
/* ============================ 继承 ============================ */

}
