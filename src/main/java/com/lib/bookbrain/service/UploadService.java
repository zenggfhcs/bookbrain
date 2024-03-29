package com.lib.bookbrain.service;

import com.lib.bookbrain.model.exchange.Response;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
Response upload(MultipartFile file);

// todo 添加类型

}
