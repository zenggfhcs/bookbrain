package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookInfoFilter;
import com.lib.bookbrain.service.BookInfoService;
import com.lib.bookbrain.service.UploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

@PostMapping("/cover:upload")
public Response cover(@RequestParam MultipartFile file) {
	return uploadService.upload(file);
}

@GetMapping("/bookType/firstLevel")
public Response firstLevelType() {
	return bookInfoService.getFirstLevelType();
}

@PostMapping("/list:quick-query")
public Response quickQuery(@RequestBody FilterPayload<BookInfo, BookInfoFilter> payload) {
	return bookInfoService.quickQuery(payload);
}

@GetMapping("/bookType{bookType}")
public Response typeQuery(@PathVariable String bookType, @RequestParam List<String> orders) {
	return bookInfoService.typeQuery(bookType, orders);
}

}
