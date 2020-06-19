package com.server.mycloudmusic.cloudmusic.expection;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException() {
        super("Token非法");
    }
}
