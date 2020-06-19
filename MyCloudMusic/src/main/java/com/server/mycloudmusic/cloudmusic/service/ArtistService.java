package com.server.mycloudmusic.cloudmusic.service;

import com.server.mycloudmusic.cloudmusic.entity.Artist;
import com.server.mycloudmusic.cloudmusic.entity.CollectionBean;
import com.server.mycloudmusic.cloudmusic.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtistService{


    int deleteByPrimaryKey(Integer artistId);

    int insert(Artist record);


    Message<Artist> selectByPrimaryKey(Integer artistId);


    int updateByPrimaryKey(Artist record);

    Message<List<Artist>> getAll();

    Message<List<Artist>> getByName(String artistName);

}
