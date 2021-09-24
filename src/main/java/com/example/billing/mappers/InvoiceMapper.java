package com.example.billing.mappers;

import com.example.billing.dto.InvoiceRequestDTO;
import com.example.billing.dto.InvoiceResponseDTO;
import com.example.billing.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceResponseDTO invoiceToInvoiceResponceDTO(Invoice invoice);
    Invoice invoiceRequestDTOToInvoice(InvoiceRequestDTO invoiceRequestDTO);
}
