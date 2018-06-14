package com.bjst.dgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class DgtApiApplication {
	public static void main(String[] args) {
		System.err.println("开始启动...........");
		SpringApplication.run(DgtApiApplication.class, args);
		System.err.println("启动完成...........");
	}
}
