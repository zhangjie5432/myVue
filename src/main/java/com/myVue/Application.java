package com.myVue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.myVue.mapper") // 配置mybatis包扫描
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}