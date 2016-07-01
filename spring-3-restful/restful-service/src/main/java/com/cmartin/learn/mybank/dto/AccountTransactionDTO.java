package com.cmartin.learn.mybank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cmartin on 28/06/16.
 */
@Data
@AllArgsConstructor
public class AccountTransactionDTO implements Serializable {
    private String id;
    private Amount amount;
    private Date transactionDate;
    private Date date;
    private String description;
}
