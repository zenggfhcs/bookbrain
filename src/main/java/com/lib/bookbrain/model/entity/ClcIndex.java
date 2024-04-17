package com.lib.bookbrain.model.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClcIndex extends Entity {
private Integer id;
private Integer parent;
private String key;
private String value;
private List<ClcIndex> children;
}
