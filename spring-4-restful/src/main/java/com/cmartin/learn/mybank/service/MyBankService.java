package com.cmartin.learn.mybank.service;

import com.cmartin.learn.mybank.dto.AccountDTO;
import com.cmartin.learn.mybank.dto.AccountTransactionDTO;

import java.util.List;
import java.util.Optional;

/**
 * Created by cmartin on 07/07/16.
 */
public interface MyBankService {
    /**
     * @param accountDTO
     *
     * @return
     */
    Optional<Long> createAccount(AccountDTO accountDTO);

    /**
     * @param pageSize
     *
     * @return
     */
    List<AccountDTO> getAccounts(Integer pageSize);

    /**
     * @param pageSize
     *
     * @return
     */
    List<AccountTransactionDTO> getAccountTransactions(Integer pageSize);
}
