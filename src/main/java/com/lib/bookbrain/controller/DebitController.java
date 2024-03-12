package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.constant.Header;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.DebitFilter;
import com.lib.bookbrain.service.DebitService;
import org.springframework.web.bind.annotation.*;

/**
 * Debit controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/debits")
@AroundConduct
public class DebitController {
private final DebitService debitService;

public DebitController(DebitService debitService) {
	this.debitService = debitService;
}

@PostMapping("/list/select")
public Response getDebits(@RequestBody(required = false) FilterPayload<Debit, DebitFilter> payload,
                          @RequestHeader(Header.TOKEN) String ignoredToken) {
	return debitService.getBy(payload);
}

@PostMapping("/list/create")
public Response createDebit(@RequestBody(required = false) Payload<Debit> payload,
                            @RequestHeader(Header.TOKEN) String ignoredToken) {
	return debitService.create(payload);
}

@PostMapping("/{id}/select")
public Response getDebit(@RequestBody(required = false) Payload<Debit> payload,
                         @RequestHeader(Header.TOKEN) String ignoredToken, @PathVariable Integer id) {
	payload.setId(id);
	return debitService.getById(payload);
}

@PostMapping("/{id}/update")
public Response updateDebit(@RequestBody(required = false) Payload<Debit> payload,
                            @RequestHeader(Header.TOKEN) String ignoredToken, @PathVariable Integer id) {
	payload.setId(id);
	return debitService.update(payload);
}

@PostMapping("/{id}/delete")
public Response deleteDebit(@RequestBody(required = false) Payload<Debit> payload,
                            @RequestHeader(Header.TOKEN) String ignoredToken, @PathVariable Integer id) {
	payload.setId(id);
	return debitService.delete(payload);
}
}
