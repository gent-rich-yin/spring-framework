package org.springframework.samples;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableTransactionManagement
public class JDKProxy {
    public interface TransferService {
        void transfer(String from, String to, double amount);
    }

    @Component
    @Transactional
    public static class TransferServiceImpl implements TransferService {
        @Override
        public void transfer(String from, String to, double amount) {
            System.out.println(String.format("Transferring %.2f from %s to %s", amount, from, to));
        }
    }

    public static void main(String[] args) {
        try (var context = new org.springframework.context.annotation.AnnotationConfigApplicationContext(JDKProxy.class)) {
            TransferService transferService = context.getBean(TransferService.class);
            System.out.println(transferService.getClass().getName());
            System.out.println(transferService instanceof TransferService);
            System.out.println(transferService instanceof TransferServiceImpl);
        }
    }

}
