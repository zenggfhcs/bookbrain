package com.lib.bookbrain.controller;

import com.lib.bookbrain.annotation.AroundConduct;
import com.lib.bookbrain.model.*;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.service.BookInfoService;
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
public Response getBookInfos(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String ignoredToken, @RequestBody(required = false) Filter filter) {
   return bookInfoService.getBy(payload, filter);
}

@PostMapping
public Response createBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String ignoredToken) {
   return bookInfoService.create(payload);
}

@GetMapping("/{ignoredId}")
public Response getBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookInfoService.getById(payload);
}

@PatchMapping("/{ignoredId}")
public Response updateBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookInfoService.update(payload);
}

@DeleteMapping("/{ignoredId}")
public Response deleteBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookInfoService.delete(payload);
}
}
