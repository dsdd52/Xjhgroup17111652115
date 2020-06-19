package com.server.mycloudmusic.cloudmusic.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CollectionOverview {
    private Integer collectionId;

    private String collectionName;

    private Integer collectionArtist;

    private Date collectionPublishedDate;

    private String collectionSubMusic;

    private String collectionPublisher;

    private String collectionLanguage;

    private String collectionInfo;

    private String collectionImg;

    private Integer popularity;
}
