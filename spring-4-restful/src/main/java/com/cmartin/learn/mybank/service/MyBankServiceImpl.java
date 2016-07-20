package com.cmartin.learn.mybank.service;

import com.cmartin.learn.mybank.dto.AccountDTO;
import com.cmartin.learn.mybank.dto.AccountTransactionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by cmartin on 08/07/16.
 */
@Service
public class MyBankServiceImpl implements MyBankService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Optional<Long> createAccount(AccountDTO accountDTO) {
        Long id = 0L;

        return Optional.of(id);
    }

    @Override
    public List<AccountDTO> getAccounts(final Integer pageSize) {
        this.logger.debug("input param {}", pageSize);

        final ArrayList<AccountDTO> accountDTOs = new ArrayList<>();

        this.logger.debug("output dto list size {}", pageSize);

        return accountDTOs;
    }

    @Override
    public List<AccountTransactionDTO> getAccountTransactions(final Integer pageSize) {
        return new ArrayList<AccountTransactionDTO>();
    }
}
