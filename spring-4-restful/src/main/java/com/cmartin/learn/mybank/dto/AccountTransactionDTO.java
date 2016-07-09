package com.cmartin.learn.mybank.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cmartin on 28/06/16.
 */
public class AccountTransactionDTO implements Serializable {
    private String id;
    private Amount amount;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private Date transactionDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private String description;

    public AccountTransactionDTO(String id, Amount amount, Date transactionDate, Date date, String description) {
        this.id = id;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.date = date;
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
