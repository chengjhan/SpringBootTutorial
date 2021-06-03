package tw.com.skl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebApplication extends ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
	}

}
