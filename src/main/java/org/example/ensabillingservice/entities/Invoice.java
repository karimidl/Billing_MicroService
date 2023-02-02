package org.example.ensabillingservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;


import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Invoice {
    @Id
    private String id;
    private Date date;
    private BigDecimal amount;
    private int clientId;
    @Transient
    private Client client;
}
