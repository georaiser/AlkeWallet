package com.alkewallet.dto;

import com.alkewallet.entity.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private Long accountNumber;
    private String accountType;
    private double balance;
    private Client client;

}
