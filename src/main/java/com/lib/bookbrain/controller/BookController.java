package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookFilter;
import com.lib.bookbrain.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Book controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/books")
@AroundConduct
public class BookController extends BaseController<Book, BookFilter> {

private final BookService bookService;

public BookController(BookService bookService) {
	super(bookService);
	this.bookService = bookService;
}

@GetMapping("/damageLevels")
public Response getBookDamageLevelList() {
	return bookService.getBookDamageLevelList();
}

@GetMapping("/bookInfoId/{id}")
public Response getByBookInfoId(@PathVariable Integer id) {
	return bookService.getByBookInfoId(id);
}

}
