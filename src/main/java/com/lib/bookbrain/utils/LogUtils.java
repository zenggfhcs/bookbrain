package com.lib.bookbrain.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;

public class LogUtils {
public static void write(String content) {
	LocalDate nowDate = LocalDate.now();
	LocalTime nowTime = LocalTime.now();
	Path path = Path.of(
			"D:/public/error",
			nowDate.toString(),
			nowTime.getHour() + "-" + nowTime.getMinute() + ".log");
	try {
		Path parent = path.getParent();
		if (!Files.exists(parent)) {
			Files.createDirectories(parent);
		}
		Files.write(path, (content + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	} catch (IOException e) {
		throw new RuntimeException(e);
	}
}

public static void write(RuntimeException re) {

}

public static void main(String[] args) {
	write("This is a log1");
}
}
