package com.server.mycloudmusic.cloudmusic.entity;

import lombok.Data;

@Data
public class MusicOverview {
    private Integer musicId;

    private String musicName;

    private String collectionName;

    private String artistName;
}
