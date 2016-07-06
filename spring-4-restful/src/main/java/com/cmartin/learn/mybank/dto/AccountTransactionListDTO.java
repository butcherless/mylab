package com.cmartin.learn.mybank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cmartin on 30/06/16.
 */
public class AccountTransactionListDTO implements Serializable {
    @JsonProperty("list")
    private List<AccountTransactionDTO> accountTransactionDTOs;
    private String paginationKey;
    private Boolean hasNextPage;

    public AccountTransactionListDTO(List<AccountTransactionDTO> accountTransactionDTOs, String paginationKey, Boolean hasNextPage) {
        this.accountTransactionDTOs = accountTransactionDTOs;
        this.paginationKey = paginationKey;
        this.hasNextPage = hasNextPage;
    }

    public List<AccountTransactionDTO> getAccountTransactionDTOs() {
        return accountTransactionDTOs;
    }

    public void setAccountTransactionDTOs(List<AccountTransactionDTO> accountTransactionDTOs) {
        this.accountTransactionDTOs = accountTransactionDTOs;
    }

    public String getPaginationKey() {
        return paginationKey;
    }

    public void setPaginationKey(String paginationKey) {
        this.paginationKey = paginationKey;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}
