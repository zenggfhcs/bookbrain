package com.lib.bookbrain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyEnum extends Entity {
private Integer id;
private String group;
private Short key;
private String value;
}
