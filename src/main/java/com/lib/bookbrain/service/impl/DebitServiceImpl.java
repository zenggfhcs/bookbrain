package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundGet;
import com.lib.bookbrain.anno.AroundLog;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.constant.LogType;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.dao.DebitMapper;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.DebitFilter;
import com.lib.bookbrain.model.pojo.RankingsBody;
import com.lib.bookbrain.model.pojo.RankingsItem;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.DebitService;
import com.lib.bookbrain.service.MailService;
import com.lib.bookbrain.utils.MapFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

public DebitServiceImpl(DebitMapper debitMapper, SimpleThreadContext<TokenInfo> threadContext, BookMapper bookMapper, MailService mailService) {
	this.threadContext = threadContext;
	this.debitMapper = debitMapper;
	this.mailService = mailService;
	baseService = new BaseServiceImpl<>(threadContext, debitMapper);
}

@Override
@AroundLog(value = "获取借阅列表", type = LogType.R)
public Response list() {
	return baseService.list();
}

@Override
@AroundLog(value = "创建借阅记录", type = LogType.C)
public Response create(Payload<Debit> payload) {
	return baseService.create(payload);
}

@AroundGet
@Override
@AroundLog(value = "查询单一借阅记录", type = LogType.R)
public Response getById(Payload<Debit> payload) {
	return baseService.getById(payload);
}

@AroundUpdate
@Override
@AroundLog(value = "更新借阅", type = LogType.U)
public Response update(Payload<Debit> payload) {
	return baseService.update(payload);
}

@AroundDelete
@Override
@AroundLog(value = "删除借阅记录", type = LogType.D)
public Response delete(Payload<Debit> payload) {
	return baseService.delete(payload);
}

@Override
@AroundLog(value = "查询借阅列表(过滤)", type = LogType.R)
public Response filteredList(FilterPayload<Debit, DebitFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
@AroundLog(value = "催还", type = LogType.C)
public Response remind(Payload<Debit> payload) {
	Integer _userId = threadContext.get().getAud();
	User _operator = new User();
	_operator.setId(_userId);

	Debit _debit = payload.getEntity();
	_debit.setUpdatedBy(_operator);
	_debit.setCreatedBy(_operator);

	remind(_debit);

	int _remindCount = debitMapper.remind(_debit);
	if (_remindCount == 0) {
		return Response.error(ResponseInfo.ERROR);
	}
	return Response.success();
}

@Override
@AroundLog(value = "查询今日借阅数", type = LogType.R)
public Response getTodayDebitCount() {
	int _todayDebitCount = debitMapper.getTodayDebitCount();
	return Response.success(_todayDebitCount);
}

@Override
@AroundLog(value = "查询今日归还数", type = LogType.R)
public Response getTodayRestoreCount() {
	int _todayRestoreCount = debitMapper.getTodayRestoreCount();
	return Response.success(_todayRestoreCount);
}

@Override
public Response remindedList(FilterPayload<Debit, DebitFilter> payload) {
	Integer _userId = threadContext.get().getAud();
	User _operator = new User();
	_operator.setId(_userId);
	payload.getEntity().setCreatedBy(_operator);

	HashMap<String, Object> _map = new HashMap<>();
	List<Debit> _list = debitMapper.remindedList(payload);
	_map.put("list", _list);
	int _count = debitMapper.remindedCount(payload);
	_map.put("count", _count);
	return Response.success(_map);
}

@Override
@AroundLog(value = "归还", type = LogType.U)
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
@AroundLog(value = "当前未归还借阅列表", type = LogType.R)
public Response currentUnreturned() {
	Integer _userId = threadContext.get().getAud();
	User _operator = new User();
	_operator.setId(_userId);

	List<Debit> _list = debitMapper.getCurrentUnreturnedByUser(_operator);

	return Response.success(_list);
}

@Override
@AroundLog(value = "书籍借阅排行榜", type = LogType.R)
public Response bookDebitRankings(RankingsBody body) {
	List<RankingsItem<BookInfo>> _list = debitMapper.bookDebitRankings(body);
	return Response.success(_list);
}

@Override
@AroundLog(value = "用户借阅排行榜", type = LogType.R)
public Response readerDebitRankings(RankingsBody body) {
	List<RankingsItem<User>> _list = debitMapper.readerDebitRankings(body);
	return Response.success(_list);
}

void remind(Debit debit) {
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
