package com.server.mycloudmusic.cloudmusic.service;

import com.server.mycloudmusic.cloudmusic.entity.CollectionBean;
import com.server.mycloudmusic.cloudmusic.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollectionService{


    int deleteByPrimaryKey(Integer collectionId);

    int insert(CollectionBean record);

    Message<CollectionBean> selectByPrimaryKey(Integer collectionId);

    int updateByPrimaryKey(CollectionBean record);

    Message<List<CollectionBean>> getAll();

    Message<List<CollectionBean>> getByName(String collectionName);


}
