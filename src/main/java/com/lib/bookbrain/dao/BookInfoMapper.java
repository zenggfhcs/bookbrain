package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.BookInfoFilter;
import com.lib.bookbrain.model.pojo.BookType;
import com.lib.bookbrain.model.entity.ClcIndex;
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

int update(Payload<BookInfo> payload);

int insert(BookInfo entity);

int delete(Integer id);

BookInfo getToUpdate(Payload<BookInfo> payload);

List<BookInfo> filteredList(FilterPayload<BookInfo, BookInfoFilter> payload);

int getLengthByFilter(FilterPayload<BookInfo, BookInfoFilter> payload);
/* ============================ 继承 ============================ */

List<BookType> getTypeByKeyword(String keyword);

List<ClcIndex> getFirstLevelType();

List<BookInfo> quickQuery(FilterPayload<BookInfo, BookInfoFilter> payload);
}
