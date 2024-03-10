package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.Publisher;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.PublisherFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yunxia
 */
@Mapper
public interface PublisherMapper extends BaseMapper<Publisher, PublisherFilter> {
/* ============================ 继承 ============================ */
List<Publisher> getBy(FilterPayload<Publisher, PublisherFilter> payload);

int getCountByFilter(PublisherFilter filter);

Publisher getById(Payload<Publisher> payload);

int update(Payload<Publisher> payload);

int insert(Payload<Publisher> payload);

int delete(Payload<Publisher> payload);

Publisher getToUpdate(Payload<Publisher> payload);

int getByName(Payload<Publisher> payload);
/* ============================ 继承 ============================ */

}
