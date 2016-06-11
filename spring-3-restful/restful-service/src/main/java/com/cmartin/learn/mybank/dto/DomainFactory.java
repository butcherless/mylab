package com.cmartin.learn.mybank.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cmartin on 11/06/16.
 */
public class DomainFactory {
    public static AccountDTO newAccountDTO(final String number, final BigDecimal balance) {
        final AccountDTO dto = new AccountDTO();
        dto.setNumber(number);
        dto.setBalance(balance);

        return dto;
    }

    public static List<AccountDTO> newAccountDTOList(final Integer number) {
        List<AccountDTO> dtos = new ArrayList<AccountDTO>();
        for (Integer i = 0; i < number; i++) {
            AccountDTO dto = newAccountDTO("account-number-" + i, BigDecimal.valueOf(1024 * i));
            dtos.add(dto);
        }

        return dtos;
    }
}
