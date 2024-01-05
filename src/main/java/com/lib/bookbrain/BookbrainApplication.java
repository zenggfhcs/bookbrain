package com.lib.bookbrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BookbrainApplication {

public static void main(String[] args) {
   SpringApplication.run(BookbrainApplication.class, args);
}

}
