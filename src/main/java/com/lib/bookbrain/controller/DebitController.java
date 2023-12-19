package com.lib.web.controller;

import com.lib.anno.AroundConduct;
import com.lib.model.Debit;
import com.lib.model.Payload;
import com.lib.model.Filter;
import com.lib.model.Response;
import com.lib.service.DebitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/debits")
@AroundConduct
public class DebitController {
private final DebitService debitService;

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
