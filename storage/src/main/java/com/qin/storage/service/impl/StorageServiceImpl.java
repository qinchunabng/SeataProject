package com.qin.storage.service.impl;

import com.qin.storage.mapper.StorageTblMapper;
import com.qin.storage.service.StorageService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageTblMapper storageTblMapper;

    /**
     * 减库存
     * @param commodityCode 商品编码
     * @param count 减库存数量
     */
    @Override
    public void deduct(String commodityCode, Integer count) {
        LOGGER.info("Storage Service Begin ... xid: " + RootContext.getXID());
        storageTblMapper.deduct(commodityCode, count);
        LOGGER.info("Storage Service End ... ");
    }
}
