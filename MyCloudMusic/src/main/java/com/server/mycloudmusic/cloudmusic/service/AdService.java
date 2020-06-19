package com.server.mycloudmusic.cloudmusic.service;

import com.server.mycloudmusic.cloudmusic.entity.Ad;
import com.server.mycloudmusic.cloudmusic.entity.Message;
import org.springframework.stereotype.Service;

@Service
public interface AdService{


    int deleteByPrimaryKey(Integer adId);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Integer adId);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);

    Message<Ad> showAD();

}
