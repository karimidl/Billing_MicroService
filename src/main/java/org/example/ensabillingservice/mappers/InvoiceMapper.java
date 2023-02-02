package org.example.ensabillingservice.mappers;

import org.example.ensabillingservice.dto.InvoiceRequestDTO;
import org.example.ensabillingservice.dto.InvoiceResponseDTO;
import org.example.ensabillingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);

}
