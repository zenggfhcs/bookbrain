package com.lib.bookbrain.model.exchange;

import com.lib.bookbrain.model.entity.Entity;
import com.lib.bookbrain.model.filter.BaseFilter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterPayload<E extends Entity, F extends BaseFilter> extends Payload<E> {

protected F filter;

}
