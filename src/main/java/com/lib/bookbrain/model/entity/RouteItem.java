package com.lib.bookbrain.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouteItem extends Entity {
private Integer id;

private Integer parentId;

private String group;

private Integer order;

private String key;

private String label;

private String toName;

private String iconName;

private List<RouteItem> children;
}
