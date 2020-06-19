package com.server.mycloudmusic.cloudmusic.expection;

public class TokenNotExistsExpectation extends RuntimeException{
    public TokenNotExistsExpectation() {
        super("Token不存在");
    }
}
