package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.DebitMapper;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.DebitFilter;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.DebitService;
import com.lib.bookbrain.service.MailService;
import com.lib.bookbrain.utils.MapFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author yunxia
 */
@Service
public class DebitServiceImpl implements DebitService {
private final SimpleThreadContext<TokenInfo> threadContext;

private final DebitMapper debitMapper;

private final BaseServiceImpl<Debit, DebitFilter> baseService;

private final MailService mailService;

public DebitServiceImpl(DebitMapper debitMapper, SimpleThreadContext<TokenInfo> threadContext, MailService mailService) {
	this.threadContext = threadContext;
	this.debitMapper = debitMapper;
	this.mailService = mailService;
	baseService = new BaseServiceImpl<>(threadContext, debitMapper);
}

@Override
public Response list() {
	return baseService.list();
}

@Override
public Response create(Payload<Debit> payload) {
	return baseService.create(payload);
}

@AroundGet
@Override
public Response getById(Payload<Debit> payload) {
	return baseService.getById(payload);
}

@AroundUpdate
@Override
public Response update(Payload<Debit> payload) {
	return baseService.update(payload);
}

@AroundDelete
@Override
public Response delete(Payload<Debit> payload) {
	return baseService.delete(payload);
}

@Override
public Response filteredList(FilterPayload<Debit, DebitFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
public Response repay(Payload<Debit> payload) {
	repay(payload.getEntity());
	return Response.success();
}

@Override
public Response getTodayDebitCount() {
	int _dc = debitMapper.getTodayDebitCount();
	return Response.success(_dc);
}

@Override
public Response restore(Payload<Debit> payload) {
	Integer _userId = threadContext.get().getAud();
	User _operator = new User();
	_operator.setId(_userId);

	Debit _debit = payload.getEntity();
	_debit.setUpdatedBy(_operator);

	int _rc = debitMapper.restore(_debit);
	if (_rc == 0) {
		return Response.error(ResponseInfo.ESCHEAT_FAILED);
	}
	return Response.success();
}

@Override
public Response currentUnreturned() {
	Integer _userId = threadContext.get().getAud();
	User _operator = new User();
	_operator.setId(_userId);

	List<Debit> _list = debitMapper.getCurrentUnreturnedByUser(_operator);

	return Response.success(_list);
}

void repay(Debit debit) {
	String sub = "借阅到期";
	String _eml = debit.getCreatedBy().getEmail();
	mailService.send(_eml, sub, () -> {
		Map<String, Object> _map = MapFactory.Builder.builder()
				.fill("debit", debit)
				.build().map();
		return mailService.fillTemplate(MailService.TemplateName.REPAY, _map);
	});
}
}
