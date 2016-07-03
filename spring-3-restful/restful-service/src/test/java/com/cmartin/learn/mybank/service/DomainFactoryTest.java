package com.cmartin.learn.mybank.service;

import com.cmartin.learn.mybank.dto.AccountDTO;
import com.cmartin.learn.mybank.dto.AccountTransactionDTO;
import com.cmartin.learn.mybank.dto.DomainFactory;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

/**
 * Created by cmartin on 29/06/16.
 */
public class DomainFactoryTest {

    @Test
    public void testAccountTransactionDTO() {
        BigDecimal value = DomainFactory.makeBigDecimalRandomDecimal(1001d);
        String currencyCode = "EUR";
        String description = "accountTransaction description";
        AccountTransactionDTO dto = DomainFactory.newAccountTransactionDTO(value, currencyCode, description);

        Assert.assertNotNull(dto.getId());
        Assert.assertNotNull(dto.getAmount());
        Assert.assertNotNull(dto.getDate());
        Assert.assertNotNull(dto.getDescription());
        Assert.assertNotNull(dto.getTransactionDate());

        Assert.assertEquals(dto.getAmount().getValue(), value);
        Assert.assertEquals(dto.getAmount().getCurrency(), Currency.getInstance(currencyCode));
        Assert.assertEquals(dto.getDescription(), description);
    }

    @Test
    public void testAccountTransactionListDTO() {
        Integer dtoCount = 7;
        List<AccountDTO> dtos = DomainFactory.newAccountDTOList(dtoCount);

        Assert.assertEquals(dtoCount.longValue(), dtos.size());
    }
}
