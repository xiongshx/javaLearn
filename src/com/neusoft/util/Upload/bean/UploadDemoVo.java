package com.neusoft.util.Upload.bean;

import org.springframework.web.multipart.MultipartFile;

public class UploadDemoVo {
    
    /**
     * 文件
     */
    private MultipartFile imgFile;
 
    public MultipartFile getImgFile() {
        return imgFile;
    }
 
    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
 
    @Override
    public String toString() {
        return "UploadDemoVo [imgFile=" + imgFile + "]";
    }
     
    public boolean validateFile() throws Exception{
        if(this.getImgFile().getSize() > 1000 * 100){
            throw new Exception("文件最大不能超过100KB！");
        }
        return true;
    }
 
}