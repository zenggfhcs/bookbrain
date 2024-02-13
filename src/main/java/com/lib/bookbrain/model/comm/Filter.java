package com.lib.bookbrain.model.comm;

import com.lib.bookbrain.constant.Default;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Filter {

protected FilterItem<LocalDateTime> creationTime;

protected FilterItem<LocalDateTime> lastUpdatedTime;

protected FilterItem<Integer> page;
public Filter() {
   super();
   creationTime = Default.LOCAL_DATE_TIME_RANGE;
   lastUpdatedTime = Default.LOCAL_DATE_TIME_RANGE;
   page = Default.PAGE_RANGE;
}

}
