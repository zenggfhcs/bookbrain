package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.service.BookInfoService;
import org.springframework.web.bind.annotation.*;

/**
 * book info controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/bookInfos")
@AroundConduct
public class BookInfoController {
private final BookInfoService bookInfoService;

public BookInfoController(BookInfoService bookInfoService) {
   this.bookInfoService = bookInfoService;
}

@PostMapping("/list/select")
public Response getBookInfos(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String ignoredToken) {
   return bookInfoService.getBy(payload);
}

@PostMapping("/list/create")
public Response createBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String ignoredToken) {
   return bookInfoService.create(payload);
}

@PostMapping("/{ignoredId}/select")
public Response getBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookInfoService.getById(payload);
}

@PostMapping("/{ignoredId}/update")
public Response updateBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookInfoService.update(payload);
}

@PostMapping("/{ignoredId}/delete")
public Response deleteBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return bookInfoService.delete(payload);
}
}
