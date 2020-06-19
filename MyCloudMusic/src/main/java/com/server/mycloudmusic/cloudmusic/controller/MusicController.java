package com.server.mycloudmusic.cloudmusic.controller;

import com.server.mycloudmusic.cloudmusic.entity.Message;
import com.server.mycloudmusic.cloudmusic.entity.Music;
import com.server.mycloudmusic.cloudmusic.service.MusicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {
    @Resource
    private MusicService musicService;

    @GetMapping("/all")
    public Message<List<Music>> getAllMusic(){
        return musicService.getAllMusic();
    }

    @GetMapping("/")
    public Message<Music> getMusicById(int id){
        return musicService.selectByPrimaryKey(id);
    }

    @GetMapping("/top")
    public Message<List<Music>> topMusic(){
        return musicService.getTopMusic();
    }

    @GetMapping("/search")
    public Message<List<Music>> getMusic(String name){
        return musicService.getMusic("%"+name+"%");
    }

    @GetMapping("/collection")
    public Message<List<Music>> getMusicByCollection(String name){
        return musicService.getMusicByCollection(name);
    }


}
