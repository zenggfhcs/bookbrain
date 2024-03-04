package com.lib.bookbrain.model.comm;

import com.lib.bookbrain.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterPayload<T extends BaseEntity, F extends Filter> extends Payload<T> {

protected F filter;

}
