package com.lib.bookbrain.exception;

import org.springframework.stereotype.Component;

/**
 * 权限缺失异常
 *
 * @author yunxia
 */
@Component("PermissionMissException")
public class PermissionMissException extends RuntimeException {
}
