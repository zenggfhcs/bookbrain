package com.lib.bookbrain.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BaseResponseInfo {

private Integer code;

private String message;

}
