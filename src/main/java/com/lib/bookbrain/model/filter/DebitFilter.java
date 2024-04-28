package com.lib.bookbrain.model.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DebitFilter extends BaseFilter {
private FilterItem<Date> returnTime;
private FilterItem<Integer> state;
}
