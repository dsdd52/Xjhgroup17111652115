package com.server.mycloudmusic.cloudmusic.service.impl;

import com.server.mycloudmusic.cloudmusic.entity.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.server.mycloudmusic.cloudmusic.mapper.AdMapper;
import com.server.mycloudmusic.cloudmusic.entity.Ad;
import com.server.mycloudmusic.cloudmusic.service.AdService;
@Component
public class AdServiceImpl implements AdService{

    @Resource
    private AdMapper adMapper;

    @Override
    public int deleteByPrimaryKey(Integer adId) {
        return adMapper.deleteByPrimaryKey(adId);
    }

    @Override
    public int insert(Ad record) {
        return adMapper.insert(record);
    }

    @Override
    public int insertSelective(Ad record) {
        return adMapper.insertSelective(record);
    }

    @Override
    public Ad selectByPrimaryKey(Integer adId) {
        return adMapper.selectByPrimaryKey(adId);
    }

    @Override
    public int updateByPrimaryKeySelective(Ad record) {
        return adMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Ad record) {
        return adMapper.updateByPrimaryKey(record);
    }

    @Override
    public Message<Ad> showAD() {
        return Message.success(null).add(adMapper.showAD());
    }

}
