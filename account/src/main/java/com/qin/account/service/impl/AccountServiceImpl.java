package com.qin.account.service.impl;

import com.qin.account.mapper.AccountTblMapper;
import com.qin.account.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.seata.core.context.RootContext;

/**
 * @author qinch
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountTblMapper accountTblMapper;

    @Override
    public void debit(String userId, int money) {
        LOGGER.info("Account Service ... xid: " + RootContext.getXID());
        accountTblMapper.debit(userId, money);
        LOGGER.info("Account Service End ... ");
    }
}
