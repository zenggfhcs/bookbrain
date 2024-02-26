package com.lib.bookbrain.model.entity;

import com.lib.bookbrain.model.BaseEntity;
import com.lib.bookbrain.model.comm.Payload;
import com.lib.bookbrain.utils.Json;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Log extends BaseEntity {

/**
 *
 */
private Long id;

/**
 *
 */
private String type;

/**
 *
 */
private String serviceName;

/**
 *
 */
private Integer dataId;

/**
 *
 */
private String input;

/**
 *
 */
private String output = "{}";

/**
 *
 */
private Long elapsedTime = 0L;

/**
 * 执行前创建并填充日志
 *
 * @param serviceName 服务名称
 * @param payload     用于生成日志信息的 payload
 */
public static Log before(String serviceName, Payload<BaseEntity> payload) {
   return Log.builder().serviceName(serviceName).dataId(payload.getId()).input(Json.stringify(payload)).output("{}").elapsedTime(-1L).build();
}
   
}
