package com.lib.bookbrain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author yunxia
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher extends Entity {

/**
 * 出版社 Id
 */
private Integer id;

/**
 * 出版社名称
 */
private String name;

/**
 * 出版地
 */
private String place;
}
