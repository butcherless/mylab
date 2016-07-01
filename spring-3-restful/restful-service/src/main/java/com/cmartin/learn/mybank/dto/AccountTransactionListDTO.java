package com.cmartin.learn.mybank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cmartin on 30/06/16.
 */
@Data
public class AccountTransactionListDTO implements Serializable {
    @JsonProperty("list")
    private List<AccountTransactionDTO> accountTransactionDTOs;
    private String paginationKey;
    private Boolean hasNextPage;
}
