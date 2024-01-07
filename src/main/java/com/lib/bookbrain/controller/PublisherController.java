package com.lib.bookbrain.controller;

import com.lib.bookbrain.annotation.AroundConduct;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
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

@GetMapping
public Response getPublishers(@RequestBody(required = false) Payload<Publisher> payload) {
   return publisherService.getBy(payload);
}

@PostMapping
public Response createPublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String ignoredToken) {
   return publisherService.create(payload);
}

@GetMapping("/{ignoredId}")
public Response getPublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return publisherService.getById(payload);
}


@PatchMapping("/{ignoredId}")
public Response updatePublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return publisherService.update(payload);
}

@DeleteMapping("/{ignoredId}")
public Response deletePublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return publisherService.delete(payload);
}
}
