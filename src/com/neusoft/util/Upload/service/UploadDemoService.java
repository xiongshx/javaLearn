package com.neusoft.util.Upload.service;

import org.springframework.web.multipart.MultipartFile;

import com.neusoft.util.Upload.bean.UploadDemoVo;

public interface UploadDemoService {
     
    /**
     * 上传文件到指定路径
     * destinationDir 目标路径
     * 2014年6月10日
     */
    public boolean uploadFile(String destinationDir, MultipartFile file, String filename) throws Exception;
    public boolean uploadForm(UploadDemoVo demo) throws Exception;
}