package com.lib.bookbrain.model.entity;

import com.lib.bookbrain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


/**
 * @author yunxia
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookInfo extends BaseEntity {

/**
 * 书籍信息 Id
 */
private Long id;

/**
 * 出版社
 */
private Publisher publisher;

/**
 * 出版地
 */
private String publishPlace;

/**
 * 书籍 ISBN 号
 */
private String isbn;

/**
 * CIP 核验号
 */
private String cip;

/**
 * 书籍名称
 */
private String bookName;

/**
 * 书籍类型
 */
private String bookType;

/**
 * 书籍封面
 */
private String cover;

/**
 * 作者
 */
private String author;

/**
 * 书籍描述
 */
private String describe;

/**
 * 出版时间
 */
private LocalDate publishDate;

/**
 * 关键字
 */
private String keyword;

/**
 * 正文语种
 */
private String lang;

/**
 * 出版价格
 */
private Double price;

/**
 * 库存量
 */
private Integer stock;

}
