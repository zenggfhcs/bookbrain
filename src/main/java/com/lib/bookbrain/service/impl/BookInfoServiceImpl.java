package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundDelete;
import com.lib.bookbrain.anno.AroundLog;
import com.lib.bookbrain.anno.AroundUpdate;
import com.lib.bookbrain.constant.LogType;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookInfoMapper;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.dao.DebitMapper;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookInfoFilter;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.BookInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yunxia
 */
@Service
@Transactional
public class BookInfoServiceImpl implements BookInfoService {
private final SimpleThreadContext<TokenInfo> threadContext;

private final BookInfoMapper bookInfoMapper;

private final BookMapper bookMapper;

private final DebitMapper debitMapper;

private final BaseServiceImpl<BookInfo, BookInfoFilter> baseService;

public BookInfoServiceImpl(BookInfoMapper bookInfoMapper, SimpleThreadContext<TokenInfo> threadContext, BookMapper bookMapper, DebitMapper debitMapper) {
	this.threadContext = threadContext;
	this.bookInfoMapper = bookInfoMapper;
	this.bookMapper = bookMapper;
	this.debitMapper = debitMapper;
	baseService = new BaseServiceImpl<>(threadContext, bookInfoMapper);
}

@Override
@AroundLog(value = "查询书籍信息列表", type = LogType.R)
public Response list() {
	return baseService.list();
}

@Override
@AroundLog(value = "创建书籍信息", type = LogType.C)
public Response create(Payload<BookInfo> payload) {
	return baseService.create(payload);
}

@Override
@AroundLog(value = "查询单一书籍信息", type = LogType.R)
public Response getById(Payload<BookInfo> payload) {
	return baseService.getById(payload);
}

@AroundUpdate
@Override
@AroundLog(value = "更新书籍信息", type = LogType.U)
public Response update(Payload<BookInfo> payload) {
	return baseService.update(payload);
}

@AroundDelete
@Override
@AroundLog(value = "删除书籍", type = LogType.D)
public Response delete(Payload<BookInfo> payload) {
	return baseService.delete(payload);
}

@Override
@AroundLog(value = "查询书籍信息列表(过滤)", type = LogType.R)
public Response filteredList(FilterPayload<BookInfo, BookInfoFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
@AroundLog(value = "书籍检索-快速", type = LogType.R)
public Response quickQuery(FilterPayload<BookInfo, BookInfoFilter> payload) {
	List<BookInfo> _list = bookInfoMapper.quickQuery(payload);
	Map<String, Object> _map = new HashMap<>();
	_map.put("list", _list);
	_map.put("length", _list.size());
	return Response.success(_map);
}

@Override
@AroundLog(value = "书籍检索-分类", type = LogType.R)
public Response typeQuery(String bookType, List<String> orders) {
	return null;
}

@Override
@AroundLog(value = "书籍检索-关键字", type = LogType.R)
public Response getByKeyword(String key) {
	List<BookInfo> _list = bookInfoMapper.getByKeyword(key);
	return Response.success(_list);
}

@Override
@AroundLog(value = "借阅", type = LogType.U)
public Response borrow(Payload<BookInfo> payload) {
	Integer _userId = threadContext.get().getAud();
	User _operator = new User();
	_operator.setId(_userId);

	int _currentDebitCount = debitMapper.getCurrentDebitCountByUser(_operator);
	if (_currentDebitCount >= 10) {// 借阅数已达上限 todo 添加到配置文件中
		return Response.error(ResponseInfo.BORROW_NUM_UPPER_LIMIT);
	}

	int _currentExpiredDebitCount = debitMapper.getCurrentExpiredDebitCountByUser(_operator);
	if (_currentExpiredDebitCount > 0) {// 存在逾期未还
		return Response.error(ResponseInfo.HAS_EXPIRED_BORROW);
	}

	int _currentDebitTheBookInfoCount = debitMapper.getCurrentDebitTheBookInfoCountByUserId(payload.getId(), _userId);
	if (_currentDebitTheBookInfoCount > 0) {// 当前已借阅该图书
		return Response.error(ResponseInfo.IS_BORROWED);
	}

	// 查询图书信息的馆藏
	List<Book> _borrowableBookList = bookMapper.getBorrowableBookListByBookInfoId(payload.getId());

	// 对查询出来的列表循环借阅
	int i = 0;
	for (; i < _borrowableBookList.size(); i++) {
		Book _book = _borrowableBookList.get(i);
		_book.setUpdatedBy(_operator);
		int _debitResult = bookMapper.borrow(_book);
		if (_debitResult > 0) {
			break;
		}
	}

	// 借阅失败
	if (_borrowableBookList.isEmpty() || i >= _borrowableBookList.size()) {
		return Response.error(ResponseInfo.THIS_BOOK_CANNOT_BE_BORROWED);
	}

	Book _book = _borrowableBookList.get(i);
	Debit debit = Debit.fromBookAndBorrower(_book, _operator);
	int _insertCount = debitMapper.insert(debit);
	if (_insertCount == 0) {
		return Response.error(ResponseInfo.ERROR);
	}

	return Response.success();
}

}
