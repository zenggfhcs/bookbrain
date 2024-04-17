package com.lib.bookbrain.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yunxia
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Entity {

/**
 * 创建人
 */
protected User createdBy;

/**
 * 创建时间
 */
protected LocalDateTime creationTime;

/**
 * 最后更新者
 */
protected User updatedBy;

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
