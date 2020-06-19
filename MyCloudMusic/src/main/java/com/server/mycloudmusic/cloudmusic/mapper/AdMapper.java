package com.server.mycloudmusic.cloudmusic.mapper;

import com.server.mycloudmusic.cloudmusic.entity.Ad;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdMapper {
    int deleteByPrimaryKey(Integer adId);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Integer adId);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);

    Ad showAD();
}
