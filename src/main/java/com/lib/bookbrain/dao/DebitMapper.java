package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.BookInfo;
import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.DebitFilter;
import com.lib.bookbrain.model.pojo.RankingsBody;
import com.lib.bookbrain.model.pojo.RankingsItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yunxia
 */
@Mapper
public interface DebitMapper extends BaseMapper<Debit, DebitFilter> {
List<Debit> list();

Debit getById(Payload<Debit> payload);

int insert(Debit entity);

int update(Payload<Debit> payload);

int delete(Integer id);

Debit getToUpdate(Payload<Debit> payload);

List<Debit> filteredList(FilterPayload<Debit, DebitFilter> payload);

int getLengthByFilter(FilterPayload<Debit, DebitFilter> payload);

int getCountByUserId(Integer userId);

List<Debit> getExpiredByUserId(Integer userId);

int getBookCountByBookIdAndUserId(@Param("userId") Integer userId, @Param("bookId") Integer bookId);

int getTodayDebitCount();

int getTodayDebitReturnCount();

int getCurrentDebitCountByUser(User operator);

int getCurrentExpiredDebitCountByUser(User operator);

boolean getCurrentDebitHasTheBookInfoByUserId(@Param("bookInfoId") Integer bookInfoId, @Param("userId") Integer userId);

int restore(Debit debit);

List<Debit> getCurrentUnreturnedByUser(User operator);

List<RankingsItem<BookInfo>> bookDebitRankings(RankingsBody body);

List<RankingsItem<User>> readerDebitRankings(RankingsBody body);
}
