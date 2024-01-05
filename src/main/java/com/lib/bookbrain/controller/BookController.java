package com.lib.bookbrain.controller;

import com.lib.bookbrain.annotation.AroundConduct;
import com.lib.bookbrain.model.*;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@AroundConduct
public class BookController {

private final BookService bookService;

@Autowired
public BookController(BookService bookService) {
   this.bookService = bookService;
}


@GetMapping
public Response getBooks(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String ignoredToken) {
   return bookService.getBy(payload);
}

@PostMapping
public Response createBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String ignoredToken) {
   return bookService.create(payload);
}

@GetMapping("/{ignoredId}")
public Response getBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookService.getById(payload);
}

@PatchMapping("/{ignoredId}")
public Response updateBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookService.update(payload);
}

@DeleteMapping("/{ignoredId}")
public Response deleteBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookService.delete(payload);
}
}
