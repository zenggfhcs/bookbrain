package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.entity.BookInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * book info mapper
 *
 * @author yunxia
 */
@Mapper
public interface BookInfoMapper extends BaseMapper<BookInfo> {
BookInfo getById(Payload<BookInfo> payload);

List<BookInfo> getBy(Payload<BookInfo> payload);

int update(Payload<BookInfo> payload);

int create(Payload<BookInfo> payload);

int delete(Payload<BookInfo> payload);

BookInfo getByUpdate(Payload<BookInfo> payload);
}
