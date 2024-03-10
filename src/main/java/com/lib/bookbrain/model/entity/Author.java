package com.lib.bookbrain.model.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yunxia
 */
@Getter
@Setter
public class Author extends Entity {

/**
 * 作者 id
 */
private Integer id;

/**
 * 名字
 */
private String name;



private Audit auditInfo;
}
