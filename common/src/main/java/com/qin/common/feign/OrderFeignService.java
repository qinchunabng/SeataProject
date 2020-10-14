package com.qin.common.feign;

import com.qin.common.domain.Result;
import com.qin.common.domain.dto.CreateOrderDTO;
import com.qin.common.domain.dto.OrderTblDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "order-service",path = "/order")
public interface OrderFeignService {

    /**
     * 新增订单
     * @param orderDTO
     * @return
     */
    @PostMapping
    Result<OrderTblDTO> create(@RequestBody CreateOrderDTO orderDTO);
}
