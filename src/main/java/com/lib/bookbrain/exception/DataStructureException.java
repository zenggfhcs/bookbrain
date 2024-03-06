package com.lib.bookbrain.exception;

import com.lib.bookbrain.constant.ResponseInfo;
import org.springframework.stereotype.Component;

@Component("DataStructureException")
public class DataStructureException extends BaseException {
{
	info = ResponseInfo.DATA_STRUCTURE_FAILED;
}
}
