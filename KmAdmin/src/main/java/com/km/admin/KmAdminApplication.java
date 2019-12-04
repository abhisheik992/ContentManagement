package com.km.admin;

import org.springframework.boot.SpringApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.km.admin.property.FileStorageProperties;



@SpringBootApplication
@EntityScan(basePackageClasses = { 
		KmAdminApplication.class,
		Jsr310JpaConverters.class 
})
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class KmAdminApplication {
	

	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC+05:30"));
	}

	public static void main(String[] args) {
		SpringApplication.run(KmAdminApplication.class, args);
	}
	
	


}
