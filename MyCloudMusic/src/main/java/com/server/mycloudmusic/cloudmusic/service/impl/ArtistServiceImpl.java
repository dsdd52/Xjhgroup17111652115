package com.server.mycloudmusic.cloudmusic.service.impl;

import com.server.mycloudmusic.cloudmusic.entity.CollectionBean;
import com.server.mycloudmusic.cloudmusic.entity.Message;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.server.mycloudmusic.cloudmusic.entity.Artist;
import com.server.mycloudmusic.cloudmusic.mapper.ArtistMapper;
import com.server.mycloudmusic.cloudmusic.service.ArtistService;

import java.util.List;

@Component
public class ArtistServiceImpl implements ArtistService{

    @Resource
    private ArtistMapper artistMapper;

    @Override
    public int deleteByPrimaryKey(Integer artistId) {
        return artistMapper.deleteByPrimaryKey(artistId);
    }

    @Override
    public int insert(Artist record) {
        return artistMapper.insert(record);
    }

    @Override
    public Message<Artist> selectByPrimaryKey(Integer artistId) {
        return Message.success(null).add(artistMapper.selectByPrimaryKey(artistId));
    }

    @Override
    public int updateByPrimaryKey(Artist record) {
        return artistMapper.updateByPrimaryKey(record);
    }

    @Override
    public Message<List<Artist>> getAll() {
        return Message.success(null).add(artistMapper.selectAll());
    }

    @Override
    public Message<List<Artist>> getByName(String artistName) {
        return Message.success(null).add(artistMapper.selectByArtistName("%"+artistName+"%"));
    }
}
