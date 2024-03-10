package com.lib.bookbrain.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role extends Entity {
private Integer id;

private String name;


private Audit auditInfo;
}
