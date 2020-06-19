package com.server.mycloudmusic.cloudmusic.controller;

import com.server.mycloudmusic.cloudmusic.entity.Artist;
import com.server.mycloudmusic.cloudmusic.entity.Message;
import com.server.mycloudmusic.cloudmusic.service.ArtistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    @Resource
    private ArtistService artistService;

    @GetMapping("/all")
    public Message<List<Artist>> getAll(){
        return artistService.getAll();
    }
    @GetMapping("/")
    public Message<Artist> getArtist(int artistId){
        return artistService.selectByPrimaryKey(artistId);
    }
    @GetMapping("/name")
    public Message<List<Artist>> getByName(String artistName){
        return artistService.getByName(artistName);
    }

}
