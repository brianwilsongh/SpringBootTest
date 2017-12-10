package io.github.wilsontheory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//one line starts servlet container (Tomcat server) and hosts app within
		SpringApplication.run(Application.class, args);
	}

}
