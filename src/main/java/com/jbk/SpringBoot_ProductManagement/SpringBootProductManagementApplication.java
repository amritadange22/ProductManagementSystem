package com.jbk.SpringBoot_ProductManagement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProductManagementApplication {

	public static Logger logger = LogManager.getLogger(SpringBootProductManagementApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProductManagementApplication.class, args);
		logger.info("I'm in INFO in SpringBootProductManagementApplication class");
		logger.debug("I'm in DEBUG");
		
		// Root Level=>
		// ALL > TRACE > DEBUG > INFO > WARN > ERROR > FATAL > OF
	}
}


/*
 * HomeWork: 
 * 1. validation: 
 * <!--https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation --> 
 * <dependency>
 * <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-starter-validation</artifactId>
 * <version>2.6.3</version> 
 * </dependency>
 * 
 * 
 * The @Validated annotation is a class-level annotation that we can use to tell Spring to validate parameters that are passed into a method of the annotated class.
 * 
 * @RestController
class ValidateRequestBodyController {

  @PostMapping("/validateBody")
  ResponseEntity<String> validateBody(@Valid @RequestBody Input input) {
    return ResponseEntity.ok("valid");
  }

}
We simply have added the @Valid annotation to the Input parameter, 
which is also annotated with @RequestBody to mark that it should be read from the request body. 
By doing this, we’re telling Spring to pass the object to a Validator before doing anything else.
 *
 * 
 */
