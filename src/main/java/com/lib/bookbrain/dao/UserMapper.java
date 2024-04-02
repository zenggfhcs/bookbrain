package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.User;
import com.lib.bookbrain.model.exchange.Payload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author yunxia
 */
@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {
/* ============================ 继承 ============================ */
int insert(User entity);

User getById(Payload<User> payload);

int delete(Integer id);

int update(Payload<User> payload);

User getToUpdate(Payload<User> payload);
/* ============================ 继承 ============================ */

/* ============================ 拓展 ============================ */
User getByToken(String token);

int register(Payload<User> payload);

User login(User entity);

int getByEmail(String email);

@Select("select count(*) from user_permission where user_id = #{id} and #{url} regexp url")
int check(@Param("id") Integer id, @Param("url") String url);


void addUserRole(Payload<User> payload);

void addUserCondition(Payload<User> payload);

/**
 * 只有没有验证过的邮箱才会进行验证
 *
 * @param email 邮箱
 */
void verifyEmail(String email);

int resetPassword(Payload<User> payload);
/* ============================ 拓展 ============================ */
}
