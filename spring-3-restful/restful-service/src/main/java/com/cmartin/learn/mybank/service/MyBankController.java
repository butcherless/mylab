package com.cmartin.learn.mybank.service;

import com.cmartin.learn.mybank.dto.AccountDTO;
import com.cmartin.learn.mybank.dto.AccountTransactionDTO;
import com.cmartin.learn.mybank.dto.AccountTransactionListDTO;
import com.cmartin.learn.mybank.dto.DomainFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;


@Controller
@RequestMapping(value = "/")
public class MyBankController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/accounts/{accountId}/accountTransactions",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<AccountTransactionListDTO> getAccountTransactionss(@RequestParam(required = false,
            defaultValue = "0") final Integer paginationSize) {

        List<AccountTransactionDTO> accountTransactionDTOs = DomainFactory.newAccountTransactionListDTO(7);

        AccountTransactionListDTO AccountTransactionListDTO = DomainFactory.newAccountTransactionListDTO(accountTransactionDTOs);

        return new ResponseEntity<AccountTransactionListDTO>(AccountTransactionListDTO, HttpStatus.OK);
    }


    @RequestMapping(value = "/accounts/{accountId}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<AccountDTO> getAccount(@PathVariable String accountId) {
        // TODO
        this.logger.debug("accountId: {}", accountId);

        final AccountDTO accountDTO = DomainFactory.newAccountDTO(
                "account-number-" + accountId, "account alias", BigDecimal.valueOf(1024.1649));

        this.logger.debug(accountDTO.toString());

        return new ResponseEntity<AccountDTO>(accountDTO, HttpStatus.OK);
    }


    @RequestMapping(value = "/accounts",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<AccountDTO>> getAccounts(@RequestParam(required = false, defaultValue = "0")
                                                        final Integer paginationSize) {
        final Integer defaultPageSize = 4;
        final Integer maxNumberOfAccounts = 10;
        final Integer accountCounter;

        if ((paginationSize == 0) || (paginationSize > maxNumberOfAccounts)) {
            accountCounter = defaultPageSize;
        } else {
            accountCounter = paginationSize;
        }

        this.logger.debug("retrieving customer accounts");

        this.logger.debug("pagination size: {}", accountCounter);

        List<AccountDTO> dtos = DomainFactory.newAccountDTOList(accountCounter);

        return new ResponseEntity<List<AccountDTO>>(dtos, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userId}/accounts",
            method = RequestMethod.POST)
    public ResponseEntity createAccount(@PathVariable String userId, @RequestBody AccountDTO accountDTO) {
        this.validateUser(userId);
        this.validateAccountDTO(accountDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    private void validateAccountDTO(final AccountDTO accountDTO) {
        this.logger.debug("validating: {}", accountDTO);
    }

    private void validateUser(final String userId) {
        this.logger.debug("user id: {} is Ok", userId);
    }


}

/*
 * client url:
 * http://localhost:8080/myarchetype-restful/restful/templateService
 * /templateOperation/7
 * http://localhost:8080/myarchetype-restful/restful
 * /templateService/templateOperation/MAIN_FLOW
 */