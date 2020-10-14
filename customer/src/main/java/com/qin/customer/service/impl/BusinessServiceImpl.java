package com.qin.customer.service.impl;

import com.qin.common.domain.dto.CreateOrderDTO;
import com.qin.common.domain.dto.DeductDTO;
import com.qin.common.domain.vo.PurchaseVO;
import com.qin.common.feign.OrderFeignService;
import com.qin.common.feign.StorageFeignService;
import com.qin.customer.service.BusinessService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qinch
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessServiceImpl.class);

    @Autowired
    private OrderFeignService orderFeignService;

    @Autowired
    private StorageFeignService storageFeignService;

    @GlobalTransactional
    @Override
    public void purchase(PurchaseVO purchaseVO) {
        LOGGER.info("purchase begin ... xid: " + RootContext.getXID());
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setCommodityCode(purchaseVO.getCommodityCode());
        createOrderDTO.setOrderCount(purchaseVO.getOrderCount());
        createOrderDTO.setUserId(purchaseVO.getUserId());
        orderFeignService.create(createOrderDTO);

        DeductDTO deductDTO = new DeductDTO();
        deductDTO.setCommodityCode(purchaseVO.getCommodityCode());
        deductDTO.setCount(purchaseVO.getOrderCount());
        storageFeignService.deduct(deductDTO);
    }
}
