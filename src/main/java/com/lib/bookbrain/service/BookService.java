package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Book;
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

Response getBookInfoByKeyword(String key);

Response borrow(Book book);

Response escheat(Book book);
}
