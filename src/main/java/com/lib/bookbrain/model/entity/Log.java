package com.lib.bookbrain.model.entity;

import com.lib.bookbrain.constant.LogType;
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

public void fillType(String type) {
   this.setType(type);
}

public void fillType(LogType type) {
   fillType(type.getValue());
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

public void fillCreatedBy(Integer createdBy) {
   this.setCreatedBy(createdBy);
}

public Log fillElapsedTime(Long time) {
   this.setElapsedTime(time);
   return this;
}

public void fillOutput(String output) {
   setOutput(output);
}
}
