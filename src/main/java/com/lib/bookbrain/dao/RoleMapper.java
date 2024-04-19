package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.Role;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.RoleFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleFilter> {
/* ============================ 继承 ============================ */
Role getById(Payload<Role> payload);

int insert(Role entity);

int update(Payload<Role> payload);

int delete(Integer id);

Role getToUpdate(Payload<Role> payload);

List<Role> filteredList(FilterPayload<Role, RoleFilter> payload);

int getLengthByFilter(FilterPayload<Role, RoleFilter> payload);

Role getByUserId(Integer userId);
/* ============================ 继承 ============================ */

}
