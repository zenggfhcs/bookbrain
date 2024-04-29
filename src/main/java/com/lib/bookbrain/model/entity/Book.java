package com.lib.bookbrain.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author yunxia
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book extends Entity {

/**
 * 书籍唯一标识
 */
private Integer id;

/**
 * 书籍破损级别
 */
private Short damageLevel;

/**
 * 可借的
 */
private Boolean borrowable;

/**
 * 书籍出版信息
 */
private BookInfo bookInfo;

/**
 * 书籍索引号
 */
private String libIndex;

private Debit currentDebit;

}
