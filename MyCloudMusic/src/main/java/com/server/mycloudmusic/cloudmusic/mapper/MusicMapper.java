package com.server.mycloudmusic.cloudmusic.mapper;

import com.server.mycloudmusic.cloudmusic.entity.Music;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

@Mapper
public interface MusicMapper {
    int deleteByPrimaryKey(Integer musicId);

    int insert(Music record);

    Music selectByPrimaryKey(Integer musicId);

    int updateByPrimaryKey(Music record);

    List<Music> selectAllMusic();

    List<Music> selectTopMusic();

    List<Music> selectMusicByName(String name);

    List<Music> selectMusicByCollection(String musicCollection);

    List<Music> selectMusicByArtist(String musicArtist);
}
