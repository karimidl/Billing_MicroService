package org.example.ensabillingservice.service;

import org.example.ensabillingservice.dto.InvoiceRequestDTO;
import org.example.ensabillingservice.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);

    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> invoicesByClientId(int clientId);


    /*List<InvoiceResponseDTO> allInvoices();*/

    void deleteInvoice(String id);

    List<InvoiceResponseDTO> allInvoices();
}
