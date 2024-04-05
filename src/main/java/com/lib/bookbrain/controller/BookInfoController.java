package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.BookInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * book info controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/bookInfos")
@AroundConduct
public class BookInfoController extends BaseController<BookInfo> {
private final BookInfoService bookInfoService;

public BookInfoController(BookInfoService bookInfoService) {
	super(bookInfoService);
	this.bookInfoService = bookInfoService;
}

@GetMapping("/bookType/{key}")
public Response bookType(@PathVariable String key) {
	return bookInfoService.getTypeByKeyword(key);
}


}
