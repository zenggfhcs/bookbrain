package com.lib.bookbrain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yunxia
 */
@Getter
@Setter
public class Author extends BaseEntity {

/**
 * 作者 id
 */
private Integer id;

/**
 * 名字
 */
private String name;
}
