package com.lib.bookbrain.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role extends Entity {
private Integer id;

private String name;

private List<Permission> permissions;

private List<RouteItem> routeItems;
}
