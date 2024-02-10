package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.dto.Payload;
import com.lib.bookbrain.model.dto.Response;
import com.lib.bookbrain.model.entity.Publisher;
import com.lib.bookbrain.service.PublisherService;
import org.springframework.web.bind.annotation.*;

/**
 * publisher controller
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
public Response getPublishers(@RequestBody(required = false) Payload<Publisher> payload) {
   return publisherService.getBy(payload);
}

@PostMapping("/list/create")
public Response createPublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String ignoredToken) {
   return publisherService.create(payload);
}

@PostMapping("/{ignoredId}/select")
public Response getPublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return publisherService.getById(payload);
}


@PostMapping("/{ignoredId}/update")
public Response updatePublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return publisherService.update(payload);
}

@PostMapping("/{ignoredId}/delete")
public Response deletePublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return publisherService.delete(payload);
}
}
