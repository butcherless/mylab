package com.cmartin.learn.mybank.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by cmartin on 11/06/16.
 */
@Data
public class AccountDTO implements Serializable {
    private String number;
    private String alias;
    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal balance;
}
