package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Permission;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.PermissionFilter;

public interface PermissionService extends BaseService<Permission, PermissionFilter> {
Response tokenPermission();
}
