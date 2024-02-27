package com.lib.bookbrain.dao;

import com.lib.bookbrain.model.Condition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConditionMapper {
    /* ============================ 继承 ============================ */
    Condition getById(Integer id);

    List<Condition> getBy();

    int insert(Condition condition);

    int update(Condition condition);

    int delete(Integer id);

    Condition getToUpdate(Condition condition);
    /* ============================ 继承 ============================ */
}
