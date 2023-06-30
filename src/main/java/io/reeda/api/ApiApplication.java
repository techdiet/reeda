package io.reeda.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Configuration
	public class OpenApiConfig {
		@Bean
		public OpenAPI usersMicroserviceOpenAPI() {
			return new OpenAPI()
					.info(new Info().title("Library system API Documentation")
							.description("Library Management system using SpringBoot")
							.version("1.0.0"));
		}
	}
}
