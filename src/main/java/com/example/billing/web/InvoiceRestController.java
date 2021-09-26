package com.example.billing.web;

import com.example.billing.dto.InvoiceRequestDTO;
import com.example.billing.dto.InvoiceResponseDTO;
import com.example.billing.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class InvoiceRestController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceRestController(InvoiceService invoiceService){
        this.invoiceService=invoiceService;
    }

    @GetMapping(path = "invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String id){

        InvoiceResponseDTO invoiceResponseDTO =invoiceService.getInvoice(id);
        return invoiceResponseDTO;
    }

    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDTO> getInvoicesByCustomer(@PathVariable String customerId){

        List<InvoiceResponseDTO> invoiceResponseDTOList = invoiceService.invoiceByCustomerId(customerId);
        return invoiceResponseDTOList;
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> getInvoices(){

        List<InvoiceResponseDTO> invoiceResponseDTOList = invoiceService.allInvoices();
        return invoiceResponseDTOList;
    }


    @PostMapping(path = "/save")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){

        InvoiceResponseDTO invoiceResponseDTO = invoiceService.save(invoiceRequestDTO);
        return invoiceResponseDTO;


    }

    @PostMapping(path = "/update")
    public InvoiceResponseDTO update(@RequestBody InvoiceRequestDTO invoiceRequestDTO){

        InvoiceResponseDTO invoiceResponseDTO = invoiceService.update(invoiceRequestDTO);
        return invoiceResponseDTO;


    }

    @DeleteMapping(path = "/invoices/{id}")
    public void delete(@PathVariable String id){

         invoiceService.deleteInvoice(id);


    }
}
