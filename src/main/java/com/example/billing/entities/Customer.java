package com.example.billing.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    private String id;
    private String email;
    private String name;

}
