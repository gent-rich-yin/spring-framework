package org.springframework.samples;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAnnotation {
    static class A {
        private final B b;
        public A(B b) {
            this.b = b;
        }
    }

    static class B {}

    @Bean
    public A a(B b) {
        return new A(b);
    }

    @Bean
    public B b() {
        return new B();
    }

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeanAnnotation.class)) {
            A a = context.getBean(A.class);
            B b = context.getBean(B.class);
            System.out.println(String.format("a: %s, a.b: %s", a, a.b));
            System.out.println(String.format("b: %s", b));
        }
    }
}
