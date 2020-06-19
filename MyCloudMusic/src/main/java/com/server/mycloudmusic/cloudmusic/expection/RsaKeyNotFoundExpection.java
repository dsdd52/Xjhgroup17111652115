package com.server.mycloudmusic.cloudmusic.expection;

public class RsaKeyNotFoundExpection extends RuntimeException {
    public RsaKeyNotFoundExpection(){
        super("密钥文件未找到");
    }
}
