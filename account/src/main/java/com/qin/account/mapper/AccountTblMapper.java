package com.qin.account.mapper;

import com.qin.account.domain.AccountTbl;
import org.apache.ibatis.annotations.Param;

public interface AccountTblMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountTbl record);

    int insertSelective(AccountTbl record);

    AccountTbl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountTbl record);

    int updateByPrimaryKey(AccountTbl record);

    void debit(@Param("userId") String userId, @Param("money") int money);
}