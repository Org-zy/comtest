package com.bookstore.dao;

import com.bookstore.entity.Tradeitem;
import com.bookstore.entity.TradeitemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TradeitemMapper {
    int countByExample(TradeitemExample example);

    int deleteByExample(TradeitemExample example);

    int deleteByPrimaryKey(Integer itemid);

    int insert(Tradeitem record);

    int insertSelective(Tradeitem record);

    List<Tradeitem> selectByExample(TradeitemExample example);

    Tradeitem selectByPrimaryKey(Integer itemid);

    int updateByExampleSelective(@Param("record") Tradeitem record, @Param("example") TradeitemExample example);

    int updateByExample(@Param("record") Tradeitem record, @Param("example") TradeitemExample example);

    int updateByPrimaryKeySelective(Tradeitem record);

    int updateByPrimaryKey(Tradeitem record);
}