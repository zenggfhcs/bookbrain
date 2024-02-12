package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yunxia
 */
@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {
/* ============================ 继承 ============================ */
List<User> getBy(Payload<User> payload);

int insert(Payload<User> payload);

User getById(Payload<User> payload);

int delete(Payload<User> payload);

int update(Payload<User> payload);

User getToUpdate(Payload<User> payload);
/* ============================ 继承 ============================ */

/* ============================ 拓展 ============================ */
User getByToken(String token);

int has(Payload<User> payload);

User login(Payload<User> payload);
/* ============================ 拓展 ============================ */
}
