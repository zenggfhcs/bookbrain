package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.RouteItem;
import com.lib.bookbrain.model.filter.BaseFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RouteMapper extends BaseMapper<RouteItem, BaseFilter> {
List<RouteItem> getFirstLevel();

List<RouteItem> getByGroup(Map<String, Object> map);
}
