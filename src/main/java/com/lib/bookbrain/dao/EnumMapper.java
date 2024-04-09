package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.MyEnum;
import com.lib.bookbrain.model.filter.BaseFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnumMapper extends BaseMapper<MyEnum, BaseFilter> {
List<MyEnum> getEnumsByGroup(String group);
}
