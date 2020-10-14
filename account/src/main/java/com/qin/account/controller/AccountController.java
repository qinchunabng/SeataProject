package com.qin.account.controller;

import com.qin.account.service.AccountService;
import com.qin.common.domain.Result;
import com.qin.common.domain.dto.DebitDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "账号管理")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation("扣款操作")
    @PostMapping("/debit")
    public Result debit(@Valid @RequestBody DebitDTO debitDTO){
        accountService.debit(debitDTO.getUserId(), debitDTO.getMoney());
        return Result.success(null);
    }
}
