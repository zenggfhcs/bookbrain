package com.lib.dao;

import com.lib.model.Filter;
import com.lib.model.Payload;
import com.lib.model.Publisher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PublisherMapper extends BaseMapper<Publisher> {
List<Publisher> getBy(@Param("payload") Payload<Publisher> payload, @Param("filter") Filter filter);

Publisher getById(Payload<Publisher> payload);

int update(Payload<Publisher> payload);

int create(Payload<Publisher> payload);

int delete(Payload<Publisher> payload);

Publisher getByUpdate(Payload<Publisher> payload);
}
