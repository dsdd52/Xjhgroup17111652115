package com.server.mycloudmusic.cloudmusic.service.impl;

import com.server.mycloudmusic.cloudmusic.entity.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.server.mycloudmusic.cloudmusic.mapper.MusicMapper;
import com.server.mycloudmusic.cloudmusic.entity.Music;
import com.server.mycloudmusic.cloudmusic.service.MusicService;

import java.util.List;

@Component
public class MusicServiceImpl implements MusicService {

    @Resource
    private MusicMapper musicMapper;

    @Override
    public int deleteByPrimaryKey(Integer musicId) {
        return musicMapper.deleteByPrimaryKey(musicId);
    }

    @Override
    public int insert(Music record) {
        return musicMapper.insert(record);
    }


    @Override
    public Message<Music> selectByPrimaryKey(Integer musicId) {
        return Message.success(null).add(musicMapper.selectByPrimaryKey(musicId));
    }

    @Override
    public int updateByPrimaryKey(Music record) {
        return musicMapper.updateByPrimaryKey(record);
    }

    @Override
    public Message<List<Music>> getAllMusic() {
        List<Music> musicList = musicMapper.selectAllMusic();
        return musicList == null ? Message.fail("错误") : Message.success(null).add(musicList);
    }

    @Override
    public Message<List<Music>> getTopMusic() {
        List<Music> musicList = musicMapper.selectTopMusic();
        return musicList == null ? Message.fail("错误") : Message.success(null).add(musicList);
    }

    @Override
    public Message<List<Music>> getMusic(String musicName) {
        List<Music> musicList = musicMapper.selectMusicByName(musicName);
        return musicList == null ? Message.fail("错误") : Message.success(null).add(musicList);
    }

    @Override
    public Message<List<Music>> getMusicByCollection(String musicName) {
        List<Music> musicList = musicMapper.selectMusicByCollection(musicName);
        return musicList == null ? Message.fail("错误") : Message.success(null).add(musicList);
    }


}

