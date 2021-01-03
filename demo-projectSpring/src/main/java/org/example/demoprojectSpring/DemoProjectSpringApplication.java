package org.example.demoprojectSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

// 异步任务
@EnableAsync
// 定时任务
@EnableScheduling
// 扫描web得servelt filter listner
@ServletComponentScan
// 启动类
@SpringBootApplication
public class DemoProjectSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectSpringApplication.class, args);
	}

}
