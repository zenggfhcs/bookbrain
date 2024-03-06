package com.lib.bookbrain.dao;

import com.lib.bookbrain.dto.FilterPayload;
import com.lib.bookbrain.dto.Payload;
import com.lib.bookbrain.dto.filter.UserFilter;
import com.lib.bookbrain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yunxia
 */
@Component
@Mapper
public interface UserMapper extends BaseMapper<User, UserFilter> {
/* ============================ 继承 ============================ */
List<User> getBy(FilterPayload<User, UserFilter> payload);

int insert(Payload<User> payload);

User getById(Payload<User> payload);

int delete(Payload<User> payload);

int update(Payload<User> payload);

User getToUpdate(Payload<User> payload);
/* ============================ 继承 ============================ */

/* ============================ 拓展 ============================ */
User getByToken(String token);

int register(Payload<User> payload);

User login(Payload<User> payload);

int getByEmail(String email);

@Select("select count(*) from user_permission where user_id = #{id} and url = #{url}")
int check(@Param("id") Integer id, @Param("url") String url);

/* ============================ 拓展 ============================ */
}
