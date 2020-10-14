package com.qin.customer.controller;

import com.qin.common.domain.Result;
import com.qin.common.domain.vo.PurchaseVO;
import com.qin.customer.service.BusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author qinch
 */
@Api(tags = "消费管理")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private BusinessService businessService;

    @ApiOperation("购买")
    @PostMapping("/purchase")
    public Result purchase(@Valid @RequestBody PurchaseVO purchaseVO){
        businessService.purchase(purchaseVO);
        return Result.success(null);
    }
}
