package com.lib.web.controller;

import com.lib.anno.AroundConduct;
import com.lib.model.*;
import com.lib.service.BookInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookInfos")
@AroundConduct
public class BookInfoController {
private final BookInfoService bookInfoService;

public BookInfoController(BookInfoService bookInfoService) {
   this.bookInfoService = bookInfoService;
}

@GetMapping
public Response getBookInfos(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String token, @RequestBody(required = false) Filter filter) {
   return bookInfoService.getBy(payload, filter);
}

@PostMapping
public Response createBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String token) {
   return bookInfoService.create(payload);
}

@GetMapping("/{id}")
public Response getBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookInfoService.getById(payload);
}

@PatchMapping("/{id}")
public Response updateBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookInfoService.update(payload);
}

@DeleteMapping("/{id}")
public Response deleteBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return bookInfoService.delete(payload);
}
}
