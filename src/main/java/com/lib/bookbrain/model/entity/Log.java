package com.lib.bookbrain.model.entity;

import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.utils.Json;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Log extends Entity {

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
private String output;

/**
 *
 */
private Long elapsedTime;

/**
 * 执行前创建并填充日志
 *
 * @param serviceName 服务名称
 * @param payload     用于生成日志信息的 payload
 */
@Deprecated
public static Log before(String serviceName, Payload<Entity> payload) {
	return Log.builder()
			.serviceName(serviceName)
			.dataId(payload.getId())
			.input(Json.stringify(payload))
			.output("{}")
			.elapsedTime(-1L).build();
}

public static Log before(String serviceName) {
	return Log.builder()
			.serviceName(serviceName)
			.dataId(null)
			.input("{}")
			.output("{}")
			.elapsedTime(-1L).build();
}

}
