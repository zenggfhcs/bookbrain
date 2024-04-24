package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.entity.ClcIndex;
import com.lib.bookbrain.model.exchange.FilterPayload;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.filter.ClcIndexFilter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClcIndexMapper extends BaseMapper<ClcIndex, ClcIndexFilter> {
/* ============================ 继承 ============================ */
ClcIndex getById(Payload<ClcIndex> payload);

int insert(ClcIndex entity);

int update(Payload<ClcIndex> payload);

int delete(Integer id);

ClcIndex getToUpdate(Payload<ClcIndex> payload);

List<ClcIndex> filteredList(FilterPayload<ClcIndex, ClcIndexFilter> payload);

int getLengthByFilter(FilterPayload<ClcIndex, ClcIndexFilter> payload);
/* ============================ 继承 ============================ */

List<ClcIndex> firstLevel();

List<ClcIndex> getByKeyword(String key);

List<ClcIndex> getByParent(Integer parent);
}
