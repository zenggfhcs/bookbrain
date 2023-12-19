package com.lib.web.controller;

import com.lib.anno.AroundConduct;
import com.lib.model.*;
import com.lib.service.BookService;
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
public Response getBooks(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String token, @RequestBody(required = false) Filter filter) {
   return bookService.getBy(payload, filter);
}

@PostMapping
public Response createBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String token) {
   return bookService.create(payload);
}

@GetMapping("/{id}")
public Response getBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookService.getById(payload);
}

@PatchMapping("/{id}")
public Response updateBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookService.update(payload);
}

@DeleteMapping("/{id}")
public Response deleteBook(@RequestBody(required = false) Payload<Book> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookService.delete(payload);
}
}
