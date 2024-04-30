package com.lib.bookbrain.service;

import com.lib.bookbrain.model.entity.Role;
import com.lib.bookbrain.model.exchange.Payload;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.model.filter.RoleFilter;

public interface RoleService extends BaseService<Role, RoleFilter> {
Response tokenRole();

Response addPermission(Payload<Role> payload);

Response removePermission(Payload<Role> payload);

Response addRoute(Payload<Role> payload);

Response removeRoute(Payload<Role> payload);
}
