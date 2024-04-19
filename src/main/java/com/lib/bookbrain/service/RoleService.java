package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Role;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.RoleFilter;

public interface RoleService extends BaseService<Role, RoleFilter> {
Response tokenRole();
}
