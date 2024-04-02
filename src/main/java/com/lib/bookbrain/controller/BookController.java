package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.service.BookService;
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
public class BookController extends BaseController<Book>  {

private final BookService bookService;

public BookController(BookService bookService) {
	super(bookService);
	this.bookService = bookService;
}

}
