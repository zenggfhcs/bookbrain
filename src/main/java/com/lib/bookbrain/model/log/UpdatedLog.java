package com.lib.bookbrain.model.log;

import com.lib.bookbrain.model.entity.BaseEntity;
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
public class UpdatedLog extends BaseEntity {
/**
 * 日志 id
 */
private Long logId;
/**
 * 修改的数据类名
 */
private String dataClass;
/**
 * 数据 id
 */
private Integer dataId;
/**
 * 旧的数据
 */
private String oldData;
/**
 * 新的数据
 */
private String newData;
/**
 * 方法耗时
 */
private Long elapsedTime;
}
