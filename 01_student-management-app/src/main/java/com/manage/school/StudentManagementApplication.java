package com.manage.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * @SpringBootApplication annotation includes @EnableAutoConfiguration,  @ComponentScan, and @SpringBootConfiguration.
 * 
 * @EnableAutoConfiguration annotation enables the auto-configuration of Spring ApplicationContext by scanning the classpath components and registering the beans.
 * 
 * @ComponentScan which is used along with the @Configuration annotation to specify the packages that we want to be scanned. @ComponentScan without arguments 
 * tells Spring to scan the current package and all of its sub-packages
 * 
 * @SpringBootConfiguration annotation annotates the Application class. This indicates to the Spring container that the class has @Bean definition methods. 
 * In other words, it contains methods that instantiate and configure our dependencies.Furthermore, the container processes the configuration class. 
 * This, in turn, generates beans for the application. As a result, we can now use Dependency Injection annotations like @Autowired or @Inject.
 * @SpringBootConfiguration is an alternative to the @Configuration annotation. The main difference is that @SpringBootConfiguration allows 
 * configuration to be automatically located.This can be especially useful for unit or integration tests.
 * 
 * @Bean annotation is part of spring framework and not specific to spring boot.It is used to explicitly declare a single bean.
 * It is a method level annotation and is used to configure beans inside java code when we use annotation based approach rather the xml based approach for 
 * spring application and then it can be called from the class using the ApplicationC  context.
 * 
 * @EnableSwagger2 annotation is required for configuring swagger, once the dependencies are added in pom we need to add this annotation to the application.java 
 * class to get the swagger ui at the url http://localhost:8080/swagger-ui.html
 *   
 */
@EnableSwagger2
@SpringBootApplication
public class StudentManagementApplication { 

	public static void main(String args[]) {
		SpringApplication.run(StudentManagementApplication.class, args);
		System.out.println("Welcome to Student Management Application.");
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();	    
	    messageSource.setBasename("classpath:application");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean;
	}
}
