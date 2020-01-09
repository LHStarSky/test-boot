package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		SpringApplication.run(SpringbootDemoApplication.class, args);
		System.out.print("/*\n *\t === SpringApplication 启动成功，用时 [ " + (System.currentTimeMillis() - start) + " ] ms. === \n*/\n");
	}

}
