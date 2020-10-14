package com.qin.order.service;

import com.qin.common.domain.dto.CreateOrderDTO;
import com.qin.common.domain.dto.OrderTblDTO;

public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderTblDTO create(CreateOrderDTO orderDTO);
}
