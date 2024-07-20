package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookFilter;

public interface BookService extends BaseService<Book, BookFilter> {

@Override
Response create(Payload<Book> payload);

@Override
Response getById(Payload<Book> payload);

@Override
Response update(Payload<Book> payload);

@Override
Response delete(Payload<Book> payload);

@Override
Response filteredList(FilterPayload<Book, BookFilter> payload);

Response getBookDamageLevelList();

Response getByBookInfoId(Integer id);

Response collectionInfo();

Response getListByKeyword(String keyword);

Response borrow(Debit debit);

Response restore(Book book);
}
