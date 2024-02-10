package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.dto.Payload;
import com.lib.bookbrain.model.dto.Response;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * debit controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/debits")
@AroundConduct
public class DebitController {
private final DebitService debitService;

@Autowired
public DebitController(DebitService debitService) {
   this.debitService = debitService;
}

@PostMapping("/list/select")
public Response getDebits(@RequestBody(required = false) Payload<Debit> payload) {
   return debitService.getBy(payload);
}

@PostMapping("/list/create")
public Response createDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String ignoredToken) {
   return debitService.create(payload);
}

@PostMapping("/{ignoredId}/select")
public Response getDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return debitService.getById(payload);
}

@PostMapping("/{ignoredId}/update")
public Response updateDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return debitService.update(payload);
}

@PostMapping("/{ignoredId}/delete")
public Response deleteDebit(@RequestBody(required = false) Payload<Debit> payload, @RequestHeader("token") String ignoredToken, @PathVariable Integer ignoredId) {
   return debitService.delete(payload);
}
}
