package com.qin.common.feign;

import com.qin.common.domain.Result;
import com.qin.common.domain.dto.DeductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author qinch
 */
@FeignClient(value = "storage-service",path = "/storage")
public interface StorageFeignService {

    @PostMapping("/deduct")
    Result deduct(@RequestBody DeductDTO deductDTO);
}
