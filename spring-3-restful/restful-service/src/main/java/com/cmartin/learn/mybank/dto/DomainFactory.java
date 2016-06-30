package com.cmartin.learn.mybank.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

/**
 * Created by cmartin on 11/06/16.
 */
public class DomainFactory {
    public static AccountDTO newAccountDTO(final String number, final String alias, final BigDecimal balance) {
        final AccountDTO dto = new AccountDTO();
        dto.setNumber(number);
        dto.setAlias(alias);
        dto.setBalance(balance);

        return dto;
    }

    public static List<AccountDTO> newAccountDTOList(final Integer number) {
        List<AccountDTO> dtos = new ArrayList<AccountDTO>();
        for (Integer i = 1; i <= number; i++) {
            AccountDTO dto = newAccountDTO("account-number-" + i, "alias-" + i, BigDecimal.valueOf(1024 * i));
            dtos.add(dto);
        }

        return dtos;
    }

    public static List<AccountTransactionDTO> newAccountTransactionListDTO(final Integer number) {
        List<AccountTransactionDTO> dtos = new ArrayList<AccountTransactionDTO>();
        for (Integer i = 1; i <= number; i++) {
            AccountTransactionDTO dto = newAccountTransactionDTO(Double
                    .valueOf(1024 * i + 1), "EUR", "account transaction " + "description-" + i);
            dtos.add(dto);
        }

        return dtos;
    }

    public static AccountTransactionDTO newAccountTransactionDTO(BigDecimal value, Currency currency, String description) {
        Amount amount = new Amount(value, currency);
        Date transactionDate = new Date();

        return new AccountTransactionDTO(amount, transactionDate, transactionDate, description);
    }

    public static AccountTransactionDTO newAccountTransactionDTO(Double value, String currencyCode, String description) {
        return newAccountTransactionDTO(BigDecimal.valueOf(value), Currency.getInstance(currencyCode), description);
    }
}
