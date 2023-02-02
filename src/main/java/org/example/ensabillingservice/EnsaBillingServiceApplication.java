package org.example.ensabillingservice;

import org.example.ensabillingservice.dto.InvoiceRequestDTO;
import org.example.ensabillingservice.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class EnsaBillingServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(EnsaBillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(InvoiceService invoiceService){
        return args -> {
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(76000),1));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(22000),2));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(47100),1));
//            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(85631),"C04"));
        };
    }
}
