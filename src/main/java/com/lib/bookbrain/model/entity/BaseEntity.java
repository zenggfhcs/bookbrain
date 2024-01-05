package com.lib.bookbrain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

/**
 * 创建人
 */
protected Integer createBy;

/**
 * 创建时间
 */
protected LocalDateTime createTime;

/**
 * 最后更新者
 */
protected Integer updateBy;

/**
 * 最后更新时间
 */
protected LocalDateTime updateTime;

/**
 * 版本号，乐观锁
 */
protected Integer revision;
}
