package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.BookFilter;
import com.lib.bookbrain.model.pojo.CollectionInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Book mapper
 *
 * @author yunxia
 */
@Mapper
public interface BookMapper extends BaseMapper<Book, BookFilter> {
/* ============================ 继承 ============================ */
Book getById(Payload<Book> payload);

int insert(Book entity);

int update(Payload<Book> payload);

int delete(Integer id);

Book getToUpdate(Payload<Book> payload);

List<Book> filteredList(FilterPayload<Book, BookFilter> payload);

int getLengthByFilter(FilterPayload<Book, BookFilter> payload);
/* ============================ 继承 ============================ */

List<BookInfo> getBookInfoByKeyword(String key);

int borrow(Book book);

Book getDebitBookById(Integer id);

List<Book> getByBookInfoId(Integer id);

List<Book> getBorrowableBookListByBookInfoId(Integer id);

List<CollectionInfo> collectionInfo();
}
