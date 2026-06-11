package org.springframework.samples;

public class SampleBean {

	private final String name;

	public SampleBean(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println("Hello from " + name + "! This is running through Spring context.");
	}
}
