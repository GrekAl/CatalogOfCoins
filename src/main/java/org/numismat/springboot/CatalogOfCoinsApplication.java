package org.numismat.springboot;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.numismat.springboot.model.Coin;
import org.numismat.springboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("org.numismat.springboot.mapper")
@MappedTypes({User.class, Coin.class})
public class CatalogOfCoinsApplication extends SpringBootServletInitializer {
	
	private final Logger logger = LoggerFactory.getLogger(CatalogOfCoinsApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CatalogOfCoinsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CatalogOfCoinsApplication.class, args);
	}
}
