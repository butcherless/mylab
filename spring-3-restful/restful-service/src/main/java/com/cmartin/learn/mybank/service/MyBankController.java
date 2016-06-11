package com.cmartin.learn.mybank.service;

import com.cmartin.learn.mybank.dto.AccountDTO;
import com.cmartin.learn.mybank.dto.DomainFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;


@Controller
@RequestMapping(value = "/accounts")
public class MyBankController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/{accountId}",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<AccountDTO> getAccount(@PathVariable String accountId) {
        // TODO
        this.logger.debug("accountId: {}", accountId);

        final AccountDTO accountDTO =
                DomainFactory.newAccountDTO("account-number-" + accountId, BigDecimal.valueOf(1024.16));

        this.logger.debug(accountDTO.toString());

        return new ResponseEntity<AccountDTO>(accountDTO, HttpStatus.OK);
    }


    @RequestMapping(value = "/",
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
}

/*
 * client url:
 * http://localhost:8080/myarchetype-restful/restful/templateService
 * /templateOperation/7
 * http://localhost:8080/myarchetype-restful/restful
 * /templateService/templateOperation/MAIN_FLOW
 */