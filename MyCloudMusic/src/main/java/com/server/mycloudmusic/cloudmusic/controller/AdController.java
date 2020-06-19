package com.server.mycloudmusic.cloudmusic.controller;

import com.server.mycloudmusic.cloudmusic.entity.Ad;
import com.server.mycloudmusic.cloudmusic.entity.Message;
import com.server.mycloudmusic.cloudmusic.service.AdService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ad")
public class AdController {
    @Resource
    private AdService adService;
    @GetMapping("/")
    public Message<Ad> getAd(){
        return adService.showAD();
    }
}
