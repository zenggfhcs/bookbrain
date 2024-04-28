package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.Permission;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.PermissionFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission, PermissionFilter> {
/* ============================ 继承 ============================ */
Permission getById(Payload<Permission> payload);

List<Permission> list();

int insert(Permission entity);

int update(Payload<Permission> payload);

int delete(Integer id);

Permission getToUpdate(Payload<Permission> payload);

List<Permission> filteredList(FilterPayload<Permission, PermissionFilter> payload);

int getLengthByFilter(FilterPayload<Permission, PermissionFilter> payload);

int isExistByName(String name);

List<Permission> getByUserId(Integer operatorId);
/* ============================ 继承 ============================ */
}
