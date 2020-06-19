package com.server.mycloudmusic.cloudmusic.mapper;

import com.server.mycloudmusic.cloudmusic.entity.CollectionBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectionMapper {
    int deleteByPrimaryKey(Integer collectionId);

    int insert(CollectionBean record);

    CollectionBean selectByPrimaryKey(Integer collectionId);

    int updateByPrimaryKey(CollectionBean record);

    List<CollectionBean> selectAll();

    List<CollectionBean> selectByName(String collectionName);
}
