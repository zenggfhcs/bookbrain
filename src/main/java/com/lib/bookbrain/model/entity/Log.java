package com.lib.bookbrain.model.entity;

import com.lib.bookbrain.constants.LogType;
import com.lib.bookbrain.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log extends BaseEntity {
/**
 *
 */
private Integer id;
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


public static Log generate() {
   return new Log();
}

public Log fillType(String type) {
   this.setType(type);
   return this;
}

public Log fillType(LogType type) {
   return fillType(type.getValue());
}

public Log fillServiceName(String serviceName) {
   this.setServiceName(serviceName);
   return this;
}

public Log fillDataId(Integer dataId) {
   this.setDataId(dataId);
   return this;
}

public Log fillInput(String input) {
   this.setInput(input);
   return this;
}

public Log fillCreatedBy(Integer createdBy) {
   this.setCreatedBy(createdBy);
   return this;
}

public Log fillElapsedTime(Long time) {
   this.setElapsedTime(time);
   return this;
}

public Log fillOutput(String output) {
   setOutput(output);
   return this;
}
}
