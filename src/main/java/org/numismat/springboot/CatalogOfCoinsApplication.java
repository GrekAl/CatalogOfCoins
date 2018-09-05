package org.numismat.springboot;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.numismat.springboot.model.Coin;
import org.numismat.springboot.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.numismat.springboot.mapper")
@MappedTypes({User.class, Coin.class})
public class CatalogOfCoinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogOfCoinsApplication.class, args);
	}
}
