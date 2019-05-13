package com.boot.spring.klu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.boot.spring.klu.mapper")
public class KyParkingSvrApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyParkingSvrApplication.class, args);
	}

}
