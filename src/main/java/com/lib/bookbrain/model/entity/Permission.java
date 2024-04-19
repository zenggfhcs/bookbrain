package com.lib.bookbrain.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Permission extends Entity {
private Integer id;
private String name;
private String url;
}
