package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.Publisher;
import com.lib.bookbrain.model.exchange.Payload;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yunxia
 */
@Mapper
public interface PublisherMapper extends BaseMapper<Publisher> {
/* ============================ 继承 ============================ */
Publisher getById(Payload<Publisher> payload);

int update(Payload<Publisher> payload);

int insert(Publisher entity);

int delete(Integer id);

Publisher getToUpdate(Payload<Publisher> payload);

int getCountByName(String name);
/* ============================ 继承 ============================ */

}
