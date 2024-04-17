package com.lib.bookbrain.service.impl;

import com.lib.bookbrain.constant.ResponseInfo;
import com.lib.bookbrain.exception.FileUploadException;
import com.lib.bookbrain.model.exchange.Response;
import com.lib.bookbrain.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

private final String BASE_URL = "http://10.3.105.0/public/";

@Override
public Response upload(MultipartFile file) {
	if (file.isEmpty()) {
		return Response.error(ResponseInfo.FILE_NOT_EXIST);
	}

	String sourceFileName = file.getOriginalFilename();
	String saveFileName = UUID.randomUUID() + "-" + sourceFileName;
	Path writePath = Path.of("D:", "public", saveFileName);

	write(writePath, false, file);

	return Response.success(BASE_URL + saveFileName);
}

public void write(Path writePath, boolean appendFlag, MultipartFile file) {
	try (OutputStream out = new BufferedOutputStream(new FileOutputStream(writePath.toFile(), appendFlag))) {
		if (!Files.exists(writePath)) {
			Files.createFile(writePath);
		}
		out.write(file.getBytes());
		out.flush();

	} catch (IOException e) {
		throw new FileUploadException();
	}
}
}
