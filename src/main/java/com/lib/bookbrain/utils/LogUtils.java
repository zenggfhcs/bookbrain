package com.lib.bookbrain.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;

public class LogUtils {

private static final String INTERVAL = "=".repeat(20);

public static void log(String content) {
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
		Files.write(path, (nowDate + " " + nowTime + "\n" + INTERVAL + "\n" + content + "\n" + INTERVAL + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	} catch (IOException e) {
		throw new RuntimeException(e);
	}
}

public static void log(RuntimeException re) {

}

public static void main(String[] args) {
	log("This is a log1");
}
}
