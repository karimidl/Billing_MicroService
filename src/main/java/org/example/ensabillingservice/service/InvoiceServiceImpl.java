package org.example.ensabillingservice.service;

import org.example.ensabillingservice.dto.InvoiceRequestDTO;
import org.example.ensabillingservice.dto.InvoiceResponseDTO;
import org.example.ensabillingservice.entities.Client;
import org.example.ensabillingservice.entities.Invoice;
import org.example.ensabillingservice.mappers.InvoiceMapper;
import org.example.ensabillingservice.openfeign.ClientRestClient;
import org.example.ensabillingservice.repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional

public class InvoiceServiceImpl implements InvoiceService {
    private  InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private ClientRestClient clientRestClient;
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, ClientRestClient clientRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.clientRestClient = clientRestClient;
    }


    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {

        Invoice invoice=invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setDate(new Date());
        invoice.setId(UUID.randomUUID().toString());
        Invoice saveInvoice=invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(saveInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice=invoiceRepository.findById(invoiceId).get();
        Client client = clientRestClient.getClient(invoice.getClientId());
        invoice.setClient(client);
        return invoiceMapper.fromInvoice(invoice);
    }



    @Override
    public List<InvoiceResponseDTO> invoicesByClientId(int clientId) {
        List<Invoice> invoices=invoiceRepository.findByClientId(clientId);
        for(Invoice invoice:invoices) {
            Client client = clientRestClient.getClient(invoice.getClientId());
            invoice.setClient(client);
        }
        return invoices.stream()
                     .map(invoice->invoiceMapper.fromInvoice(invoice))
                    .collect(Collectors.toList());
    }
    @Override
    public void deleteInvoice(String id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices= invoiceRepository.findAll();
       for(Invoice invoice:invoices) {
            Client client = clientRestClient.getClient(invoice.getClientId());
            invoice.setClient(client);
        }
        return invoices.stream()
                .map(inv->invoiceMapper.fromInvoice(inv))
                .collect(Collectors.toList());
    }
}
/*
   @Override
    public List<InvoiceResponseDTO> allInvoices() {
        List<Invoice> invoices= invoiceRepository.findAll();
       for(Invoice invoice:invoices) {
           Client customer = customerRestClient.getClient(invoice.getCustomerId());
           invoice.setClient(customer);

           return invoices.stream().map(inv -> invoiceMapper.fromInvoice(inv)).collect(Collectors.toList());
       }
    } */

