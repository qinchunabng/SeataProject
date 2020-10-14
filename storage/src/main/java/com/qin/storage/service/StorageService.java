package com.qin.storage.service;

/**
 * @author qinch
 */
public interface StorageService {

    /**
     * 减库存
     * @param commodityCode 商品编码
     * @param count 减库存数量
     */
    void deduct(String commodityCode, Integer count);
}
