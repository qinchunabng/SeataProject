package com.qin.order.service.impl;

import com.qin.common.domain.dto.CreateOrderDTO;
import com.qin.common.domain.dto.DebitDTO;
import com.qin.common.domain.dto.OrderTblDTO;
import com.qin.common.feign.AccountFeignService;
import com.qin.order.domain.OrderTbl;
import com.qin.order.mapper.OrderTblMapper;
import com.qin.order.service.OrderService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qinch
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderTblMapper orderTblMapper;

    @Autowired
    private AccountFeignService accountFeignService;

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class )
    @Override
    public OrderTblDTO create(CreateOrderDTO orderDTO) {
        LOGGER.info("Order Service Begin ... xid: " + RootContext.getXID());

        // 计算订单金额
        int orderMoney = calculate(orderDTO.getCommodityCode(), orderDTO.getOrderCount());

        // 从账户余额扣款
        accountFeignService.debit(new DebitDTO(orderDTO.getUserId(), orderMoney));

        //新增订单
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setCommodityCode(orderDTO.getCommodityCode());
        orderTbl.setCount(orderDTO.getOrderCount());
        orderTbl.setMoney(orderMoney);
        orderTbl.setUserId(orderDTO.getUserId());
        orderTblMapper.insert(orderTbl);

        OrderTblDTO orderTblDTO = new OrderTblDTO();
        orderTblDTO.setCommodityCode(orderTbl.getCommodityCode());
        orderTblDTO.setCount(orderTbl.getCount());
        orderTblDTO.setId(orderTbl.getId());
        orderTblDTO.setMoney(orderTbl.getMoney());
        orderTblDTO.setUserId(orderTbl.getUserId());
        return orderTblDTO;
    }

    private int calculate(String commodityId, int orderCount) {
        return 200 * orderCount;
    }
}
