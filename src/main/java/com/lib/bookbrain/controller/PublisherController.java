package com.lib.web.controller;

import com.lib.anno.AroundConduct;
import com.lib.model.*;
import com.lib.service.PublisherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publishers")
@AroundConduct
public class PublisherController {
private final PublisherService publisherService;

public PublisherController(PublisherService publisherService) {
   this.publisherService = publisherService;
}

@GetMapping
public Response getPublishers(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String token, @RequestBody(required = false) Filter filter) {
   return publisherService.getBy(payload, filter);
}

@PostMapping
public Response createPublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String token) {
   return publisherService.create(payload);
}

@GetMapping("/{id}")
public Response getPublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return publisherService.getById(payload);
}


@PatchMapping("/{id}")
public Response updatePublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return publisherService.update(payload);
}

@DeleteMapping("/{id}")
public Response deletePublisher(@RequestBody(required = false) Payload<Publisher> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return publisherService.delete(payload);
}
}
