package com.lib.bookbrain.controller;

import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.UploadService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@RequestMapping("/upload")
public class UploadController {

private final UploadService uploadService;

@PostMapping("/cover")
public Response cover(@RequestParam MultipartFile file) {
	return uploadService.upload(file);
}
}
