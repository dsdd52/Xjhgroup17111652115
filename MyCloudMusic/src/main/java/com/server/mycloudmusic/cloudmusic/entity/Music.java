package com.server.mycloudmusic.cloudmusic.entity;

import lombok.Data;

@Data
public class Music {
    private Integer musicId;

    private String musicName;

    private String musicCollection;

    private String musicArtist;

    private Integer musicNumber;

    private Integer musicLenth;

    private String musicLanguage;

    private Integer popularity;

    private String localAddress;

    private String musicImg;
}
