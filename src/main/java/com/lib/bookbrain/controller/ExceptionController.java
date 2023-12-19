package com.lib.web.controller;

import com.lib.model.Response;
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
   Integer code = (Integer) attr.getOrDefault("status", 678);
   String msg = attr.get("error") + " " + attr.get("path");
   return Response.error(code, msg);
}

private Map<String, Object> getAttr(HttpServletRequest request) {
   return getErrorAttributes(request, ErrorAttributeOptions.defaults());
}
}
