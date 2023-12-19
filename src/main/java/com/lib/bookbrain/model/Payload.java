package com.lib.bookbrain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 参数载体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payload<T extends BaseEntity> {
/**
 * id
 */
protected Integer id;
/**
 * 参数实体
 */
protected T entity;
/**
 * 请求者
 */
protected transient TokenBody tokenBody;
}
