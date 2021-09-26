package com.example.billing.dto;

import com.example.billing.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceResponseDTO {

    private String id;
    private Date date;
    private BigDecimal amount;
    private Customer customer;

}
