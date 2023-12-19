package com.lib.bookbrain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Filter {
protected static LocalDateTime lower_TIME_DEFAULT_VALUE = LocalDateTime.of(2023, 1, 1, 0, 0);
protected static LocalDateTime upper_TIME_DEFAULT_VALUE = LocalDateTime.of(2038, 1, 1, 0, 0);
/**
 * 创建时间下限
 */
protected LocalDateTime lowerCreateTime = lower_TIME_DEFAULT_VALUE;
/**
 * 创建时间上限
 */
protected LocalDateTime upperCreateTime = upper_TIME_DEFAULT_VALUE;
/**
 * 最后更新时间下限
 */
protected LocalDateTime lowerUpdateTime = lower_TIME_DEFAULT_VALUE;
/**
 * 最后更新时间上限
 */
protected LocalDateTime upperUpdateTime = upper_TIME_DEFAULT_VALUE;
/**
 * 分页查询-起始行
 */
protected Integer pageStart = 0;
/**
 * 分页查询-页长
 */
protected Integer pageSize = 10;
/**
 * 年龄下限
 */
private Integer lowerAge = 0;
/**
 * 年龄上限
 */
private Integer upperAge = 238;
/**
 * 最后登录时间下限
 */
private LocalDateTime lowerLastLoginTime = lower_TIME_DEFAULT_VALUE;
/**
 * 最后登录时间上限
 */
private LocalDateTime upperLastLoginTime = upper_TIME_DEFAULT_VALUE;

/**
 * 执行时间下限
 */
private Long lowerElapsedTime = 0L;
/**
 * 执行时间上限
 */
private Long upperElapsedTime = 10000L;
}
