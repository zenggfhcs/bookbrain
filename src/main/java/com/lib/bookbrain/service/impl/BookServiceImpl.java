package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.anno.AroundLog;
import com.lib.bookbrain.constant.LogType;
import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.context.SimpleThreadContext;
import com.lib.bookbrain.dao.BookMapper;
import com.lib.bookbrain.dao.DebitMapper;
import com.lib.bookbrain.dao.EnumMapper;
import com.lib.bookbrain.exception.BaseException;
import com.lib.bookbrain.model.entity.Book;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.entity.MyEnum;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.BookFilter;
import com.lib.bookbrain.model.pojo.CollectionInfo;
import com.lib.bookbrain.model.pojo.TokenInfo;
import com.lib.bookbrain.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yunxia
 */
@Service
public class BookServiceImpl implements BookService {

private final SimpleThreadContext<TokenInfo> threadContext;

private final BookMapper bookMapper;

private final EnumMapper enumMapper;

private final BaseServiceImpl<Book, BookFilter> baseService;

private final DebitMapper debitMapper;

public BookServiceImpl(BookMapper bookMapper, EnumMapper enumMapper, SimpleThreadContext<TokenInfo> threadContext, DebitMapper debitMapper) {
	this.bookMapper = bookMapper;
	this.enumMapper = enumMapper;
	this.threadContext = threadContext;
	baseService = new BaseServiceImpl<>(threadContext, bookMapper);
	this.debitMapper = debitMapper;
}

@Override
@AroundLog(value = "查询书籍列表", type = LogType.R)
public Response list() {
	return baseService.list();
}

@Override
@AroundLog(value = "创建书籍", type = LogType.R)
public Response create(Payload<Book> payload) {
	return baseService.create(payload);
}

@Override
@AroundLog(value = "查询单一书籍", type = LogType.R)
public Response getById(Payload<Book> payload) {
	return baseService.getById(payload);
}

@Override
@AroundLog(value = "更新书籍", type = LogType.U)
public Response update(Payload<Book> payload) {
	return baseService.update(payload);
}

@Override
@AroundLog(value = "删除书籍", type = LogType.D)
public Response delete(Payload<Book> payload) {
	return baseService.delete(payload);
}

@Override
@AroundLog(value = "查询书籍列表(过滤)", type = LogType.R)
public Response filteredList(FilterPayload<Book, BookFilter> payload) {
	return baseService.filteredList(payload);
}

@Override
@AroundLog(value = "获取书籍损坏级别", type = LogType.R)
public Response getBookDamageLevelList() {
	List<MyEnum> _list = enumMapper.getEnumsByGroup("bookDamageLevel");
	return Response.success(_list);
}

@Override
@AroundLog(value = "获取书籍列表-通过书籍信息ID", type = LogType.R)
public Response getByBookInfoId(Integer id) {
	List<Book> _list = bookMapper.getByBookInfoId(id);
	return Response.success(_list);
}

@Override
@AroundLog(value = "获取馆藏信息", type = LogType.R)
public Response collectionInfo() {
	List<CollectionInfo> _list = bookMapper.collectionInfo();
	return Response.success(_list);
}

@Override
public Response getListByKeyword(String keyword) {
	String[] split = keyword.split("_");
	List<Book> _list =
			split[0].equals("debit")
					? bookMapper.getDebitListByKeyword(split[1])
					: bookMapper.getRestoreListByKeyword(split[1]);

	return Response.success(_list);
}

@Override
@AroundLog(value = "获取馆藏信息", type = LogType.R)
public Response borrow(Debit debit) {
	Integer _userId = threadContext.get().getAud();
	User _operator = new User();
	_operator.setId(_userId);

	User _borrower = debit.getCreatedBy();
// 2. 检查借阅者当前借阅数量是否已达上限
	int _currentDebitCount = debitMapper.getCurrentDebitCountByUser(_borrower);
	if (_currentDebitCount >= 10) {
		return Response.error(ResponseInfo.BORROW_NUM_UPPER_LIMIT);
	}
// 3. 检查借阅者是否存在逾期借阅
	int _currentExpiredDebitCount = debitMapper.getCurrentExpiredDebitCountByUser(_borrower);
	if (_currentExpiredDebitCount > 0) {
		return Response.error(ResponseInfo.HAS_EXPIRED_BORROW);
	}
// 4. 检查借阅者是否已借阅该图书
	int _currentDebitTheBookInfoCount = debitMapper.getCurrentDebitTheBookInfoCountByUserId(debit.getBook().getBookInfo().getId(), _borrower.getId());
	if (_currentDebitTheBookInfoCount > 0) {
		return Response.error(ResponseInfo.IS_BORROWED);
	}

	int _debitResult = bookMapper.borrow(debit.getBook());
// 7. 判断是否借阅失败
	if (_debitResult == 0) {
		return Response.error(ResponseInfo.THIS_BOOK_CANNOT_BE_BORROWED);
	}
// 8. 借阅
	debit.setUpdatedBy(_operator);
	int _insertCount = debitMapper.insert(debit);
// 9. 检查是否添加借阅记录失败，添加失败需要抛出异常进行事务回退
	if (_insertCount == 0) {
		throw new BaseException(ResponseInfo.ERROR);
	}
// 10. 返回借阅成功
	return Response.success();
}

@Override
public Response restore(Book book) {
	Integer _userId = threadContext.get().getAud();
	User _operator = new User();
	_operator.setId(_userId);

	book.setUpdatedBy(_operator);

	int _rc = bookMapper.restore(book);
	if (_rc == 0) {
		return Response.error(ResponseInfo.ESCHEAT_FAILED);
	}
	return Response.success();
}
}
