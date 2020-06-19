package com.server.mycloudmusic.cloudmusic.controller;



import com.server.mycloudmusic.cloudmusic.config.GlobalConfig;
import com.server.mycloudmusic.cloudmusic.entity.Message;
import com.server.mycloudmusic.cloudmusic.utils.GlobalFileUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/api/file")
public class GlobalFileController {

    @Resource
    private GlobalConfig config;

    /**
    * @Author: Wls
    * @Date: 17:50 2020/4/7
    * @Description: 全局文件上传接口
    */
    @PostMapping("/")
    public Message fileUpload(MultipartFile[] file) throws IOException {
        if (file.length>0) {
            String rs= GlobalFileUtils.saveFileToTempDir(config.globalFilePath,config.serverUrl,file);
            return Message.success(null).add(rs);
        }
        return Message.fail("没有读取到您的上传文件信息");
    }
}
