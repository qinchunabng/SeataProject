package com.qin.storage.mapper;

import com.qin.storage.domain.StorageTbl;
import org.apache.ibatis.annotations.Param;

public interface StorageTblMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StorageTbl record);

    int insertSelective(StorageTbl record);

    StorageTbl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StorageTbl record);

    int updateByPrimaryKey(StorageTbl record);

    int deduct(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}