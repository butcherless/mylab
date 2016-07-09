package com.cmartin.learn.mybank.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by cmartin on 28/06/16.
 */
public class Amount implements Serializable {
    private BigDecimal value;
    private Currency currency;

    public Amount(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
