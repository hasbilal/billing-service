package com.example.billing;

import com.example.billing.dto.InvoiceRequestDTO;
import com.example.billing.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return args -> {

            invoiceService.save(InvoiceRequestDTO.builder()
                    .customerId("C01")
                    .amount(BigDecimal.valueOf(37000))
                    .build());

            invoiceService.save(InvoiceRequestDTO.builder()
                    .amount(BigDecimal.valueOf(36000))
                    .customerId("C02")
                    .build());
        };
    }

}
