package com.lib.bookbrain.dto.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFilter extends BaseFilter {

protected FilterItem<Integer> age;
}

