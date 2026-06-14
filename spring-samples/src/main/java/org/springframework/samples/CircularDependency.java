package org.springframework.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class CircularDependency {
    @Component
    public static class A {
        private B b;
        @Autowired
        public void setB(B b) {
            this.b = b;
        }
        public void check() {
            System.out.println(String.format("A(%s) is live with B: %s", this, this.b));
        }
    }
    @Component
    public static class B {
        private A a;
        @Autowired
        public void setA(A a) {
            this.a = a;
        }
        public void check() {
            System.out.println(String.format("B(%s) is live with A: %s", this, this.a));
        }
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CircularDependency.class)) {
            A a = context.getBean(A.class);
            B b = context.getBean(B.class);
            a.check();
            b.check();
        }
    }
}
