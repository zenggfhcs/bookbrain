package com.lib.bookbrain.model.comm.filters;

import com.lib.bookbrain.model.comm.Filter;
import com.lib.bookbrain.model.comm.FilterItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFilter extends Filter {

private FilterItem<Integer> age;

public UserFilter() {
   super();
   age = new FilterItem<>(0, 348);
}

}
