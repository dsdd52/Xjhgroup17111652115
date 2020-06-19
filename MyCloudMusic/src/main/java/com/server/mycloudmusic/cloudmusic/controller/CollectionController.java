package com.server.mycloudmusic.cloudmusic.controller;

import com.server.mycloudmusic.cloudmusic.entity.Artist;
import com.server.mycloudmusic.cloudmusic.entity.CollectionBean;
import com.server.mycloudmusic.cloudmusic.entity.Message;
import com.server.mycloudmusic.cloudmusic.service.ArtistService;
import com.server.mycloudmusic.cloudmusic.service.CollectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Resource
    private CollectionService collectionService;

    @GetMapping("/all")
    public Message<List<CollectionBean>> getAll(){
        return collectionService.getAll();
    }
    @GetMapping("/")
    public Message<CollectionBean> getArtist(int collectionId){
        return collectionService.selectByPrimaryKey(collectionId);
    }
    @GetMapping("/name")
    public Message<List<CollectionBean>> getByName(String collectionName){
        return collectionService.getByName(collectionName);
    }
}
