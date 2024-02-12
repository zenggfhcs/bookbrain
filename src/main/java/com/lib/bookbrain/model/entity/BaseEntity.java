package com.lib.bookbrain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author yunxia
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

/**
 * 创建人
 */
protected Integer createdBy;

/**
 * 创建时间
 */
protected LocalDateTime creationTime = LocalDateTime.now();

/**
 * 最后更新者
 */
protected Integer updatedBy;

/**
 * 最后更新时间
 */
protected LocalDateTime lastUpdatedTime;

/**
 * 版本号，乐观锁
 */
protected Integer revision;

/**
 * 备注
 */
protected String remark;

}
