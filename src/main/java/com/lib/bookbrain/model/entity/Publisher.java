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
public class Publisher extends BaseEntity {
/**
 * 出版社 Id
 */
private Integer publishId;

/**
 * 出版社名称
 */
private String name;

/**
 * 备注
 */
private String remark;
}
