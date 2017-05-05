package com.wd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
//	@Configuration,
// @EnableAutoConfiguration	和	@ComponentScan	注解他们的main类。
// 由于这些 注解被如此频繁地一块使用（特别是你遵循以上最佳实践时），Spring
// Boot提供一个方便的	@SpringBootApplication	选择。

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
