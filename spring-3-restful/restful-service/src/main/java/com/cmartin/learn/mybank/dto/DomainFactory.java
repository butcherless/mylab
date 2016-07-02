package com.cmartin.learn.mybank.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by cmartin on 11/06/16.
 */
public class DomainFactory {
    public static AccountDTO newAccountDTO(final String number, final String alias, final BigDecimal balance) {
        final AccountDTO dto = new AccountDTO();
        dto.setNumber(number);
        dto.setAlias(alias);
        dto.setBalance(balance.setScale(2, BigDecimal.ROUND_HALF_UP));

        return dto;
    }

    public static List<AccountDTO> newAccountDTOList(final Integer number) {
        List<AccountDTO> dtos = new ArrayList<AccountDTO>();
        for (Integer i = 1; i <= number; i++) {
            AccountDTO dto = newAccountDTO("account-number-" + i, "alias-" + i, makeBigDecimalRandomDecimal(1024.0 * i));
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
        Amount amount = new Amount(value.setScale(2, BigDecimal.ROUND_HALF_UP), currency);
        Date transactionDate = new Date();
        String id = UUID.randomUUID().toString();
        Calendar calendar = Calendar.getInstance();
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date date = calendar.getTime();
        return new AccountTransactionDTO(id, amount, transactionDate, date, description);
    }

    public static AccountTransactionDTO newAccountTransactionDTO(Double value, String currencyCode, String description) {
        return newAccountTransactionDTO(makeBigDecimalRandomDecimal(value), Currency.getInstance(currencyCode), description);
    }

    private static AccountTransactionListDTO newAccountTransactionListDTO(
            final List<AccountTransactionDTO> dtos, final Boolean hasNextPage, final String paginationKey) {
        AccountTransactionListDTO dto = new AccountTransactionListDTO();
        dto.setAccountTransactionDTOs(dtos);
        dto.setHasNextPage(hasNextPage);
        dto.setPaginationKey(paginationKey);

        return dto;
    }

    /**
     * caso lista vacía
     *
     * @return
     */
    public static AccountTransactionListDTO newAccountTransactionListDTO() {
        return newAccountTransactionListDTO(new ArrayList<AccountTransactionDTO>(), false, "");
    }

    /**
     * caso lista con 1 página o lista vacía
     *
     * @param dtos
     * @return
     */
    public static AccountTransactionListDTO newAccountTransactionListDTO(final List<AccountTransactionDTO> dtos) {
        return newAccountTransactionListDTO(dtos, false, "");
    }

    /**
     * caso lista con N páginas
     *
     * @param dtos
     * @return
     */
    public static AccountTransactionListDTO newAccountTransactionListDTO(
            final List<AccountTransactionDTO> dtos, final String paginationKey) {
        return newAccountTransactionListDTO(dtos, true, paginationKey);
    }

    private static BigDecimal makeBigDecimalRandomDecimal(final Double value) {
        return BigDecimal.valueOf(value + new Random().nextDouble());
    }
}
