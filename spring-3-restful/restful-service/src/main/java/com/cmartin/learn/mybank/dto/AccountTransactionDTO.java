package com.cmartin.learn.mybank.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private Date transactionDate;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private Date date;
    private String description;
}
