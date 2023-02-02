package org.example.ensabillingservice.repository;

import org.example.ensabillingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {
    List<Invoice> findByClientId(int clientId);
}
