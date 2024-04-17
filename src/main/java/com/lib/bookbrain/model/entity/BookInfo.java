package com.lib.bookbrain.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookInfo extends Entity {

/**
 * 书籍信息 Id
 */
private Long id;

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
private LocalDate publishedDate;

private String publisher;

private String edition;

private String printing;

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

}
