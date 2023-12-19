package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.Debit;
import com.lib.bookbrain.model.Filter;
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
public Response getDebits(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String token, @RequestBody(required = false) Filter filter) {
   return debitService.getBy(payload, filter);
}

@PostMapping
public Response createDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String token) {
   return debitService.create(payload);
}

@GetMapping("/{id}")
public Response getDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return debitService.getById(payload);
}

@PatchMapping("/{id}")
public Response updateDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return debitService.update(payload);
}

@DeleteMapping("/{id}")
public Response deleteDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String token, @PathVariable Integer id) {
   return debitService.delete(payload);
}
}
