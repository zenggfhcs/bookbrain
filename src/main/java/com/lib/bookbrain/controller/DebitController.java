package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.DebitFilter;
import com.lib.bookbrain.model.pojo.RankingsBody;
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
public class DebitController extends BaseController<Debit, DebitFilter> {
private final DebitService debitService;

public DebitController(DebitService debitService) {
	super(debitService);
	this.debitService = debitService;
}

@PostMapping("/{id}/remind")
public Response remind(@RequestBody Debit debit) {
	Payload<Debit> _payload = Payload.fromEntity(debit);
	return debitService.remind(_payload);
}

@GetMapping("/todayDebitCount")
public Response getTodayDebitCount() {
	return debitService.getTodayDebitCount();
}

@GetMapping("/getTodayRestoreCount")
public Response getTodayRestoreCount() {
	return debitService.getTodayRestoreCount();
}

@PostMapping("/{id}/restore")
public Response restore(@RequestBody Debit debit, @PathVariable Integer id) {
	Payload<Debit> _payload = Payload.fromEntity(debit);
	_payload.setId(id);
	return debitService.restore(_payload);
}

@GetMapping("/currentUnreturned")
public Response tokenUserDebits() {
	return debitService.currentUnreturned();
}

@PostMapping("/bookDebitRankings")
public Response bookDebitRankings(@RequestBody RankingsBody body) {
	return debitService.bookDebitRankings(body);
}

@PostMapping("/readerDebitRankings")
public Response readerDebitRankings(@RequestBody RankingsBody body) {
	return debitService.readerDebitRankings(body);
}
}
