package pl.lodz.uni.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MoviesDatabaseApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MoviesDatabaseApplication.class, args);
	}
}
