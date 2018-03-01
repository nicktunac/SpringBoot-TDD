package com.kodigo.weightlogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


@EntityScan(
		basePackageClasses = {WeightloggerApplication.class, Jsr310JpaConverters.class}
)
@SpringBootApplication
public class WeightloggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeightloggerApplication.class, args);
	}
}
