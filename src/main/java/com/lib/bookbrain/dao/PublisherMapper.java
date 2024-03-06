package com.lib.bookbrain.dao;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.filter.PublisherFilter;
import com.lib.bookbrain.entity.Publisher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yunxia
 */
@Mapper
public interface PublisherMapper extends BaseMapper<Publisher, PublisherFilter> {
/* ============================ 继承 ============================ */
List<Publisher> getBy(FilterPayload<Publisher, PublisherFilter> payload);

Publisher getById(Payload<Publisher> payload);

int update(Payload<Publisher> payload);

int insert(Payload<Publisher> payload);

int delete(Payload<Publisher> payload);

Publisher getToUpdate(Payload<Publisher> payload);
/* ============================ 继承 ============================ */

}
