package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookInfoFilter;
import com.lib.bookbrain.service.BookInfoService;
import com.lib.bookbrain.service.UploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * book info controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/bookInfos")
@AroundConduct
public class BookInfoController extends BaseController<BookInfo, BookInfoFilter> {
private final BookInfoService bookInfoService;

private final UploadService uploadService;

public BookInfoController(BookInfoService bookInfoService, UploadService uploadService) {
	super(bookInfoService);
	this.bookInfoService = bookInfoService;
	this.uploadService = uploadService;
}

@GetMapping("/bookType/{key}")
public Response bookType(@PathVariable String key) {
	return bookInfoService.getTypeByKeyword(key);
}

@PostMapping("/cover:upload")
public Response cover(@RequestParam MultipartFile file) {
	return uploadService.upload(file);
}


}
