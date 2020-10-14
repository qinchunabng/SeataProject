package com.qin.storage.controller;

import com.qin.common.domain.Result;
import com.qin.common.domain.dto.DeductDTO;
import com.qin.storage.service.StorageService;
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
@Api(tags = "库存管理")
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @ApiOperation("减库存")
    @PostMapping("/deduct")
    public Result deduct(@Valid @RequestBody DeductDTO deductDTO){
        storageService.deduct(deductDTO.getCommodityCode(), deductDTO.getCount());
        return Result.success(null);
    }
}
