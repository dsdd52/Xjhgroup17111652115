package com.server.mycloudmusic.cloudmusic.mapper;

import com.server.mycloudmusic.cloudmusic.entity.Artist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArtistMapper {
    int deleteByPrimaryKey(Integer artistId);

    int insert(Artist record);

    Artist selectByPrimaryKey(Integer artistId);

    int updateByPrimaryKey(Artist record);

    List<Artist> selectAll();

    List<Artist> selectByArtistName(String artistName);
}
