package com.lib.bookbrain.exception;

import com.lib.bookbrain.constant.ResponseInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseException extends RuntimeException {
protected ResponseInfo info;
}
