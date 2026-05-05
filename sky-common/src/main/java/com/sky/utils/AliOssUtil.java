package com.sky.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Data
@AllArgsConstructor
@Slf4j
public class AliOssUtil {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    private static final String LOCAL_PATH = "D:/sky-upload/";
    private static final String URL_PREFIX = "http://localhost:8080/upload/";

    public String upload(byte[] bytes, String objectName) {
        // 确保目录存在
        File dir = new File(LOCAL_PATH);
        if (!dir.exists()) {
            dir.mkdirs();// 没有就创建
        }

        // 把二进制内容写入文件
        File file = new File(LOCAL_PATH + objectName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(bytes);// 写入磁盘
        } catch (IOException e) {
            log.error("本地文件上传失败: {}", e.getMessage());
        }

        String url = URL_PREFIX + objectName;
        log.info("文件上传到本地: {}", url);
        return url;
    }
}