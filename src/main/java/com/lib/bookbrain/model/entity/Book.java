package com.lib.bookbrain.model.entity;

import com.lib.bookbrain.model.BaseEntity;
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
public class Book extends BaseEntity {

/**
 * 书籍唯一标识
 */
private Long id;

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

}
