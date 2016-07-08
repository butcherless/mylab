package com.cmartin.learn.mybank.service;

import com.cmartin.learn.mybank.dto.AccountDTO;
import com.cmartin.learn.mybank.dto.AccountTransactionDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by cmartin on 08/07/16.
 */
//@Service
public class MyBankServiceImpl implements MyBankService {
    @Override
    public Optional<Long> createAccount(AccountDTO accountDTO) {
        Long id = 0L;

        return Optional.of(id);
    }

    @Override
    public List<AccountDTO> getAccounts(Integer pageSize) {
        return new ArrayList<AccountDTO>();
    }

    @Override
    public List<AccountTransactionDTO> getAccountTransactions(Integer pageSize) {
        return new ArrayList<AccountTransactionDTO>();
    }
}
