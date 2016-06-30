package com.cmartin.learn.mybank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by cmartin on 28/06/16.
 */
@Data
@AllArgsConstructor
public class Amount implements Serializable {
    private BigDecimal value;
    private Currency currency;
}
