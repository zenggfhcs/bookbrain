package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.constant.HeaderName;
import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.comm.filters.BookFilter;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * book controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/books")
@AroundConduct
public class BookController {

private final BookService bookService;

@Autowired
public BookController(BookService bookService) {
   this.bookService = bookService;
}


@PostMapping("/list/select")
public Response getBooks(@RequestBody(required = false) FilterPayload<Book, BookFilter> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken) {
   return bookService.getBy(payload);
}

@PostMapping("/list/create")
public Response createBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken) {
   return bookService.create(payload);
}

@PostMapping("/{id}/select")
public Response getBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken, @PathVariable Integer id) {
   payload.setId(id);
   return bookService.getById(payload);
}

@PostMapping("/{id}/update")
public Response updateBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken, @PathVariable Integer id) {
   payload.setId(id);
   return bookService.update(payload);
}

@PostMapping("/{id}/delete")
public Response deleteBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken, @PathVariable Integer id) {
   payload.setId(id);
   return bookService.delete(payload);
}
   
}
