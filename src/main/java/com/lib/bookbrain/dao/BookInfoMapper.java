package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.Payload;
import org.apache.ibatis.annotations.Mapper;

/**
 * book info mapper
 *
 * @author yunxia
 */
@Mapper
public interface BookInfoMapper extends BaseMapper<BookInfo> {
/* ============================ 继承 ============================ */
BookInfo getById(Payload<BookInfo> payload);

int update(Payload<BookInfo> payload);

int insert(BookInfo entity);

int delete(Integer id);

BookInfo getToUpdate(Payload<BookInfo> payload);
/* ============================ 继承 ============================ */

}
