package org.example.ensabillingservice.dto;

import lombok.*;
import org.example.ensabillingservice.entities.Client;

import java.math.BigDecimal;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class InvoiceResponseDTO {

    private String id;
    private Date date;
    private BigDecimal amount;
    private Client client;
}
