package org.springframework.samples;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

public class TracingApplication {

	public static void main(String[] args) throws IOException{
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			SampleBean sampleBean = context.getBean(SampleBean.class);
			sampleBean.run();
			System.out.println(String.join("\n", context.getBeanDefinitionNames()));
			Resource resource = context.getResource("classpath:test/subtest/test.properties");
			System.out.println(resource.getClass().getCanonicalName());
			System.out.println(String.join("\n", resource.getContentAsString(StandardCharsets.UTF_8).lines().toList()));

			System.out.println("PropertySources:");
			context.getEnvironment().getPropertySources().forEach(propertySource -> {
				System.out.println(propertySource.getClass().getCanonicalName());
				System.out.println(propertySource.getName());
				System.out.println(propertySource);
				System.out.println("----");				
			});
		}
	}
}
