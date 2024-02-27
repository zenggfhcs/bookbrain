package com.lib.bookbrain.exception;

import com.lib.bookbrain.constant.ResponseInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {
    protected ResponseInfo info;
}
