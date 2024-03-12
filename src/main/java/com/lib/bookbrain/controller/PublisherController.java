package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.constant.Header;
import com.lib.bookbrain.model.entity.Publisher;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.PublisherFilter;
import com.lib.bookbrain.service.PublisherService;
import org.springframework.web.bind.annotation.*;

/**
 * Publisher controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/publishers")
@AroundConduct
public class PublisherController {
private final PublisherService publisherService;

public PublisherController(PublisherService publisherService) {
	this.publisherService = publisherService;
}

@PostMapping("/list/select")
public Response getPublishers(@RequestBody(required = false) FilterPayload<Publisher, PublisherFilter> payload,
                              @RequestHeader(Header.TOKEN) String ignoredToken) {
	return publisherService.getBy(payload);
}

@PostMapping("/list/create")
public Response createPublisher(@RequestBody(required = false) Payload<Publisher> payload,
                                @RequestHeader(Header.TOKEN) String ignoredToken) {
	return publisherService.create(payload);
}

@PostMapping("/{id}/select")
public Response getPublisher(@RequestBody(required = false) Payload<Publisher> payload,
                             @RequestHeader(Header.TOKEN) String ignoredToken, @PathVariable Integer id) {
	payload.setId(id);
	return publisherService.getById(payload);
}

@PostMapping("/{id}/update")
public Response updatePublisher(@RequestBody(required = false) Payload<Publisher> payload,
                                @RequestHeader(Header.TOKEN) String ignoredToken, @PathVariable Integer id) {
	payload.setId(id);
	return publisherService.update(payload);
}

@PostMapping("/{id}/delete")
public Response deletePublisher(@RequestBody(required = false) Payload<Publisher> payload,
                                @RequestHeader(Header.TOKEN) String ignoredToken, @PathVariable Integer id) {
	payload.setId(id);
	return publisherService.delete(payload);
}
}
