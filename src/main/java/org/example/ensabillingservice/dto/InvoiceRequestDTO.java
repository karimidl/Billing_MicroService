package org.example.ensabillingservice.dto;

import lombok.*;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InvoiceRequestDTO {

    private BigDecimal amount;
    private int clientId;

}
