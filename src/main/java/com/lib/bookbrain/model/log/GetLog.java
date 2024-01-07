package com.lib.bookbrain.model.log;

import com.lib.bookbrain.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * @author yunxia
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetLog extends BaseEntity {
/**
 * 日志 id
 */
private Long logId;
/**
 * 调用方法所属的类
 */
private String className;
/**
 * 调用方法名
 */
private String method;
/**
 * 方法接收的参数
 */
private String payload;
/**
 * 方法的返回结果
 */
private String returnValue;
/**
 * 方法耗时
 */
private Long elapsedTime;
/**
 * 日志创建时间
 */
private LocalDateTime createTime;
/**
 * 日志创建者（方法调用者）
 */
private Integer createBy;

public static GetLog create() {
   return new GetLog();
}
}
