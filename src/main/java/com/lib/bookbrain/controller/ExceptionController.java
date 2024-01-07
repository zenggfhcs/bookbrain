package com.lib.bookbrain.controller;

import com.lib.bookbrain.constants.ResponseCode;
import com.lib.bookbrain.model.Response;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 拦截 error，使 500、404 等情况返回的数据格式为自定义数据格式
 *
 * @author yunxia
 */
@RestController
@RequestMapping("/error")
public class ExceptionController extends AbstractErrorController {
@Autowired
public ExceptionController(ErrorAttributes errorAttributes) {
   super(errorAttributes);
}

public ExceptionController(ErrorAttributes errorAttributes, List<ErrorViewResolver> errorViewResolvers) {
   super(errorAttributes, errorViewResolvers);
}

@GetMapping
public Response customError(HttpServletRequest request) {
   Map<String, Object> attr = getAttr(request);
   ResponseCode code = ResponseCode.valueOf((String) attr.getOrDefault("status", ResponseCode.ERROR));
   String msg = attr.get("error") + " " + attr.get("path");
   return Response.error(code, msg);
}

private Map<String, Object> getAttr(HttpServletRequest request) {
   return getErrorAttributes(request, ErrorAttributeOptions.defaults());
}


}
