package com.lib.bookbrain.model.comm;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BaseResponseInfo {

    private Integer code;

    private String message;

}
