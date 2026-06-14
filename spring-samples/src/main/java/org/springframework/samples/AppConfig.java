package org.springframework.samples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
// import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
@PropertySource("classpath:test/subtest/test.properties")
public class AppConfig {

	// @Bean
	// public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	// 	return new PropertySourcesPlaceholderConfigurer();
	// }

	@Bean
	public SampleBean sampleBean(@Value("${sample.name}") String name) {
		return new SampleBean(name);
	}
}
