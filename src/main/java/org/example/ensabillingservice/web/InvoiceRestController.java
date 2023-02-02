package org.example.ensabillingservice.web;


import org.example.ensabillingservice.dto.InvoiceRequestDTO;
import org.example.ensabillingservice.dto.InvoiceResponseDTO;

import org.example.ensabillingservice.service.InvoiceService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {
    private final InvoiceService invoiceService;
    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String invoiceId){
    return invoiceService.getInvoice(invoiceId);
    }
    @GetMapping(path = "/invoicesByClient/{clientId}")
    public List<InvoiceResponseDTO> getInvoicesByCustomer(@PathVariable int clientId){
        return invoiceService.invoicesByClientId(clientId);
    }


    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.save(invoiceRequestDTO);
    }
  /*  @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> allInvoices(){
        return invoiceService.allInvoices();
    }*/
  @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO>allInvoices(){
        return invoiceService.allInvoices();
    }

    @DeleteMapping(path = "/invoices/{id}")
    public void delete(@PathVariable String id){
        invoiceService.deleteInvoice(id);
    }
}
