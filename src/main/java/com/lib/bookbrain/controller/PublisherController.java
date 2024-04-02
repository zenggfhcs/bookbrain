package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.Publisher;
import com.lib.bookbrain.service.PublisherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Publisher controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/publishers")
@AroundConduct
public class PublisherController extends BaseController<Publisher> {
private final PublisherService publisherService;

public PublisherController(PublisherService publisherService) {
	super(publisherService);
	this.publisherService = publisherService;
}


}
