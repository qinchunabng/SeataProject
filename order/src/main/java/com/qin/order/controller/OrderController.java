package com.qin.order.controller;

import com.qin.common.domain.dto.CreateOrderDTO;
import com.qin.common.domain.dto.OrderTblDTO;
import com.qin.common.domain.Result;
import com.qin.order.service.OrderService;
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
@Api(tags = "订单管理")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("创建订单")
    @PostMapping
    public Result<OrderTblDTO> create(@Valid @RequestBody CreateOrderDTO orderDTO){
        return Result.success(orderService.create(orderDTO));
    }
}
