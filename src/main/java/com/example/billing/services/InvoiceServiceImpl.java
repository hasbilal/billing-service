package com.example.billing.services;

import com.example.billing.dto.InvoiceRequestDTO;
import com.example.billing.dto.InvoiceResponseDTO;
import com.example.billing.mappers.InvoiceMapper;
import com.example.billing.openfeign.CustomerRestClient;
import com.example.billing.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return null;
    }

    @Override
    public InvoiceResponseDTO update(InvoiceRequestDTO invoiceRequestDTO) {
        return null;
    }

    @Override
    public InvoiceResponseDTO getInvoice(String id) {
        return null;
    }

    @Override
    public List<InvoiceResponseDTO> invoiceByCustomerId(String CustomerId) {
        return null;
    }

    @Override
    public void deleteInvoice(String id) {

    }
}
