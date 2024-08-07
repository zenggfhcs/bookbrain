package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Debit;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.DebitFilter;
import com.lib.bookbrain.model.pojo.RankingsBody;

public interface DebitService extends BaseService<Debit, DebitFilter> {
Response remind(Payload<Debit> payload);

Response getTodayDebitCount();

Response restore(Payload<Debit> payload);

Response currentUnreturned();

Response bookDebitRankings(RankingsBody body);

Response readerDebitRankings(RankingsBody body);

Response getTodayRestoreCount();

Response remindedList(FilterPayload<Debit, DebitFilter> payload);
}
