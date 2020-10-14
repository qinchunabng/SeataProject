package com.qin.common.feign;

import com.qin.common.domain.Result;
import com.qin.common.domain.dto.DebitDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qinch
 */
@FeignClient(value = "account-service",path = "/account")
public interface AccountFeignService {

    /**
     * 扣款
     * @param userId
     * @param money
     * @return
     */
    @PostMapping("/debit")
    Result debit(@RequestBody DebitDTO debitDTO);
}
