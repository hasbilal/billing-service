package com.example.billing.services;

import com.example.billing.dto.InvoiceRequestDTO;
import com.example.billing.dto.InvoiceResponseDTO;
import com.example.billing.entities.Customer;
import com.example.billing.entities.Invoice;
import com.example.billing.mappers.InvoiceMapper;
import com.example.billing.openfeign.CustomerRestClient;
import com.example.billing.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper,CustomerRestClient customerRestClient){

        this.invoiceRepository  = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }


    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {

        Invoice invoice = invoiceMapper.invoiceRequestDTOToInvoice(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        /**
         * verification de l'integrité référentielle invoice/customer
         */
        Invoice savedInvoice = invoiceRepository.save(invoice);
        InvoiceResponseDTO invoiceResponseDTO = invoiceMapper.invoiceToInvoiceResponceDTO(savedInvoice);

        return invoiceResponseDTO;
    }

    @Override
    public InvoiceResponseDTO update(InvoiceRequestDTO invoiceRequestDTO) {

        Invoice invoice = invoiceMapper.invoiceRequestDTOToInvoice(invoiceRequestDTO);
        Invoice savedInvoice = invoiceRepository.save(invoice);
        InvoiceResponseDTO invoiceResponseDTO = invoiceMapper.invoiceToInvoiceResponceDTO(savedInvoice);

        return invoiceResponseDTO;
    }

    @Override
    public InvoiceResponseDTO getInvoice(String id) {

        Invoice invoice = invoiceRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        InvoiceResponseDTO invoiceResponseDTO = invoiceMapper.invoiceToInvoiceResponceDTO(invoice);

        return invoiceResponseDTO;
    }

    @Override
    public List<InvoiceResponseDTO> invoiceByCustomerId(String CustomerId) {
        List<Invoice> invoiceList = invoiceRepository.findByCustomerId(CustomerId);
        List<InvoiceResponseDTO>invoiceResponseDTOList = invoiceList.stream()
                .map(invoice -> invoiceMapper.invoiceToInvoiceResponceDTO(invoice))
                .collect(Collectors.toList());

        return invoiceResponseDTOList;
    }

    @Override
    public void deleteInvoice(String id) {

        invoiceRepository.deleteById(id);

    }
}
