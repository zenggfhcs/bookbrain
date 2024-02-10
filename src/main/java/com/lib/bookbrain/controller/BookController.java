package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.dto.Payload;
import com.lib.bookbrain.model.dto.Response;
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
public Response getBooks(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String ignoredToken) {
   return bookService.getBy(payload);
}

@PostMapping("/list/create")
public Response createBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String ignoredToken) {
   return bookService.create(payload);
}

@PostMapping("/{ignoredId}/select")
public Response getBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookService.getById(payload);
}

@PostMapping("/{ignoredId}/update")
public Response updateBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookService.update(payload);
}

@PostMapping("/{ignoredId}/delete")
public Response deleteBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookService.delete(payload);
}

}
