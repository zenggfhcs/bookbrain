package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.filters.BookInfoFilter;
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

int update(Payload<BookInfo> payload);

int insert(Payload<BookInfo> payload);

int delete(Payload<BookInfo> payload);

BookInfo getToUpdate(Payload<BookInfo> payload);
/* ============================ 继承 ============================ */

}
