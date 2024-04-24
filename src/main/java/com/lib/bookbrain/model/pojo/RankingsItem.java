package com.lib.bookbrain.model.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RankingsItem<T> {
private Integer count;
private T target;
}
