package com.server.mycloudmusic.cloudmusic.service.impl;

import com.server.mycloudmusic.cloudmusic.entity.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import com.server.mycloudmusic.cloudmusic.entity.CollectionBean;
import com.server.mycloudmusic.cloudmusic.mapper.CollectionMapper;
import com.server.mycloudmusic.cloudmusic.service.CollectionService;

import java.util.List;

@Component
public class CollectionServiceImpl implements CollectionService{

    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public int deleteByPrimaryKey(Integer collectionId) {
        return collectionMapper.deleteByPrimaryKey(collectionId);
    }

    @Override
    public int insert(CollectionBean record) {
        return collectionMapper.insert(record);
    }

    @Override
    public Message<CollectionBean> selectByPrimaryKey(Integer collectionId) {
        return Message.success(null).add(collectionMapper.selectByPrimaryKey(collectionId));
    }

    @Override
    public int updateByPrimaryKey(CollectionBean record) {
        return collectionMapper.updateByPrimaryKey(record);
    }

    @Override
    public Message<List<CollectionBean>> getAll() {
        return Message.success(null).add(collectionMapper.selectAll());
    }

    @Override
    public Message<List<CollectionBean>> getByName(String collectionName) {
        return Message.success(null).add(collectionMapper.selectByName("%"+collectionName+"%"));
    }


}
