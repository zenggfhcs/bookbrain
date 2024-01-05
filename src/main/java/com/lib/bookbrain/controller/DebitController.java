package com.lib.bookbrain.controller;

import com.lib.bookbrain.annotation.AroundConduct;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.Response;
import com.lib.bookbrain.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/debits")
@AroundConduct
public class DebitController {
private final DebitService debitService;

@Autowired
public DebitController(DebitService debitService) {
   this.debitService = debitService;
}

@GetMapping
public Response getDebits(@RequestBody(required = false) Payload<Debit> payload) {
   return debitService.getBy(payload);
}

@PostMapping
public Response createDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String ignoredToken) {
   return debitService.create(payload);
}

@GetMapping("/{ignoredId}")
public Response getDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return debitService.getById(payload);
}

@PatchMapping("/{ignoredId}")
public Response updateDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return debitService.update(payload);
}

@DeleteMapping("/{ignoredId}")
public Response deleteDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return debitService.delete(payload);
}
}
