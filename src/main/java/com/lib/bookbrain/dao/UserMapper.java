package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.Payload;
import com.lib.bookbrain.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yunxia
 */
@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {

List<User> getBy(@Param("payload") Payload<User> payload);

int create(Payload<User> payload);

User getById(Payload<User> payload);

int delete(Payload<User> payload);

int update(Payload<User> payload);

User getByUpdate(Payload<User> payload);

User getByToken(String token);

int has(Payload<User> payload);

int login(Payload<User> payload);
}
