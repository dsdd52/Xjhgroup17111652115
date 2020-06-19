package com.server.mycloudmusic.cloudmusic.service;

import com.server.mycloudmusic.cloudmusic.entity.Message;
import com.server.mycloudmusic.cloudmusic.entity.Music;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MusicService {


    int deleteByPrimaryKey(Integer musicId);

    int insert(Music record);

    Message<Music> selectByPrimaryKey(Integer musicId);

    int updateByPrimaryKey(Music record);

    Message<List<Music>> getAllMusic();

    Message<List<Music>> getTopMusic();

    Message<List<Music>> getMusic(String musicName);

    Message<List<Music>> getMusicByCollection(String musicName);

}

