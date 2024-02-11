package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.entity.Publisher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yunxia
 */
@Mapper
public interface PublisherMapper extends BaseMapper<Publisher> {
/* ============================ 继承 ============================ */
List<Publisher> getBy(@Param("payload") Payload<Publisher> payload);

Publisher getById(Payload<Publisher> payload);

int update(Payload<Publisher> payload);

int insert(Payload<Publisher> payload);

int delete(Payload<Publisher> payload);

Publisher getToUpdate(Payload<Publisher> payload);
/* ============================ 继承 ============================ */

}
