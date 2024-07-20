package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookFilter;
import com.lib.bookbrain.service.BookService;
import org.springframework.web.bind.annotation.*;

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

@GetMapping("/keyword:{keyword}/list")
public Response getListByKeyword(@PathVariable String keyword) {
	return bookService.getListByKeyword(keyword);
}

@GetMapping("/damageLevels")
public Response getBookDamageLevelList() {
	return bookService.getBookDamageLevelList();
}

@GetMapping("/bookInfoId/{id}")
public Response getByBookInfoId(@PathVariable Integer id) {
	return bookService.getByBookInfoId(id);
}

@GetMapping("/collectionInfo")
public Response collectionInfo() {
	return bookService.collectionInfo();
}

@PostMapping("/borrow")
public Response borrow(@RequestBody Debit debit) {
	return bookService.borrow(debit);
}

@PostMapping("/{id}/restore")
public Response restore(@RequestBody Book book) {
	return bookService.restore(book);
}
}
