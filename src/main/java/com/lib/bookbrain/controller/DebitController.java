package com.lib.bookbrain.controller;

import com.lib.bookbrain.anno.AroundConduct;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.service.DebitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Debit controller
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/debits")
@AroundConduct
public class DebitController extends BaseController<Debit> {
private final DebitService debitService;

public DebitController(DebitService debitService) {
	super(debitService);
	this.debitService = debitService;
}

}
