package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.MyEnum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnumMapper extends BaseMapper<MyEnum> {
List<MyEnum> getEnumsByGroup(String group);
}
