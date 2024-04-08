package com.lib.bookbrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 存在定时任务
public class BookbrainApplication {

public static void main(String[] args) {
	SpringApplication.run(BookbrainApplication.class, args);
}


}
