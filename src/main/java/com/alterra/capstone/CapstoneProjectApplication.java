package com.alterra.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CapstoneProjectApplication {
	@Bean
	public WebMvcConfigurer getCorsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").
						allowedOrigins("*").
						allowCredentials(true).
						allowedMethods("GET", "PUT", "POST", "DELETE");

				//						allowedOrigins("http://localhost:3000").
//						allowedOrigins("http://react-front-end-capstone-kel-3-git-fetchdata-zaidantr.vercel.app").
//						allowedOrigins("http://react-front-end-capstone-kel-3.vercel.app").
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjectApplication.class, args);
	}

}
