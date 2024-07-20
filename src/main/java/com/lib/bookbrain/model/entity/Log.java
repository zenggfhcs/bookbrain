package com.lib.bookbrain.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.utils.Json;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
public static Log create(String serviceName, Payload<Entity> payload) {
	return Log.builder()
			.serviceName(serviceName)
			.input(Json.stringify(payload))
			.output("{}")
			.elapsedTime(-1L).build();
}

public static Log create() {
	return Log.builder()
			.serviceName("")
			.input("[]")
			.output("{}")
			.elapsedTime(-1L).build();
}

}
