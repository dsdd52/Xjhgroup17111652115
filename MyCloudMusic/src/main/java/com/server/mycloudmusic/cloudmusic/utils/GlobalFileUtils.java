package com.server.mycloudmusic.cloudmusic.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
* @Author: Wls
* @Date: 9:44 2020/4/17
* @Description: 全局文件工具类
*/
public class GlobalFileUtils {


    /**
    * @Author: Wls
    * @Date: 9:46 2020/4/17
    * @Description: 将文件保存至临时文件夹中
    */
    public static String saveFileToTempDir(String basePath, String serverUrl, MultipartFile[] multipartFile) throws IOException {
        System.out.println(serverUrl);
        StringBuilder filesNames = new StringBuilder();
        if (multipartFile.length>0) {
            for (MultipartFile file : multipartFile) {
                String format= file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
                String fileName= UUID.randomUUID().toString()+"."+format;
                String dir=basePath+"/";
                File f=new File(dir);
                if (!f.exists()) {
                    f.mkdirs();
                }
                File saveFile = new File(dir+fileName);
                file.transferTo(saveFile);
                filesNames.append(serverUrl+"/resource/"+fileName);
                filesNames.append(";");
                System.out.println("File saved path:"+dir+fileName);

            }
            return filesNames.toString();
        }else {
            throw new RuntimeException("文件不存在");
        }

    }


    /**
    * @Author: Wls
    * @Date: 11:34 2020/4/17
    * @Description: 未完成
    */
    public static boolean moveFileToServiceDir(String baseDir,String serviceDir,String fileNames){
        String tempDir= baseDir + "/temp/";
        String targetDir= baseDir + "/" + serviceDir + "/";

        for (String fileName : fileNames.split(";")) {
            File file=new File(tempDir+fileName);
            if (file.exists()) {
                 file.renameTo(new File(targetDir + fileName));
            }

        }
        return false;
    }

}
