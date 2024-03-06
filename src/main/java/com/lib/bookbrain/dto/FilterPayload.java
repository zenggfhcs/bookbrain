package com.lib.bookbrain.dto;

import com.lib.bookbrain.dto.filter.BaseFilter;
import com.lib.bookbrain.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterPayload<T extends BaseEntity, F extends BaseFilter> extends Payload<T> {

protected F filter;

}
