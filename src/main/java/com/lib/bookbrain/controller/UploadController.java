package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.UploadService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
public class UploadController {

private final UploadService uploadService;

@RequestMapping(path = "/users/cover:upload", method = RequestMethod.POST)
public Response cover(@RequestParam MultipartFile file) {
	return uploadService.upload(file);
}
}
