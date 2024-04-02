package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.entity.Publisher;
import com.lib.bookbrain.service.PublisherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController<Publisher> {

public final PublisherService publisherService;

public TestController(PublisherService publisherService) {
	super(publisherService);
	this.publisherService = publisherService;
}
}
