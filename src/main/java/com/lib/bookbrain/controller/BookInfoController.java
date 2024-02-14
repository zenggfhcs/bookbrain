package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.constant.HeaderName;
import com.lib.bookbrain.model.comm.FilterPayload;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.comm.Response;
import com.lib.bookbrain.model.comm.filters.BookInfoFilter;
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
public Response getBookInfos(@RequestBody(required = false) FilterPayload<BookInfo, BookInfoFilter> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken) {
   return bookInfoService.getBy(payload);
}

@PostMapping("/list/create")
public Response createBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken) {
   return bookInfoService.create(payload);
}

@PostMapping("/{id}/select")
public Response getBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken, @PathVariable Integer id) {
   payload.setId(id);
   return bookInfoService.getById(payload);
}

@PostMapping("/{id}/update")
public Response updateBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken, @PathVariable Integer id) {
   payload.setId(id);
   return bookInfoService.update(payload);
}

@PostMapping("/{id}/delete")
public Response deleteBookInfo(@RequestBody(required = false) Payload<BookInfo> payload, @RequestHeader(HeaderName.TOKEN) String ignoredToken, @PathVariable Integer id) {
   payload.setId(id);
   return bookInfoService.delete(payload);
}
}
