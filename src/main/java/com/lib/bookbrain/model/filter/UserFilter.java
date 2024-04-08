package com.lib.bookbrain.model.filter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserFilter extends BaseFilter {

protected FilterItem<Integer> age;

protected FilterItem<LocalDateTime> lastLoginTime;


}

