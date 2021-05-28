package com.example.redis.dao;

import com.example.redis.bean.Pms;
import com.example.redis.bean.PmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PmsDao {
    long countByExample(PmsExample example);

    int deleteByExample(PmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Pms record);

    int insertSelective(Pms record);

    List<Pms> selectByExample(PmsExample example);

    Pms selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Pms record, @Param("example") PmsExample example);

    int updateByExample(@Param("record") Pms record, @Param("example") PmsExample example);

    int updateByPrimaryKeySelective(Pms record);

    int updateByPrimaryKey(Pms record);
}