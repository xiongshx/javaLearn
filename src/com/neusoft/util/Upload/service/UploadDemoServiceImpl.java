package com.neusoft.util.Upload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.util.Upload.bean.UploadDemoVo;

@Service
public class UploadDemoServiceImpl implements UploadDemoService {
    
	private static Logger logger = Logger.getLogger(UploadDemoServiceImpl.class);
    
    public boolean uploadForm(UploadDemoVo demo) throws Exception {
        demo.validateFile();
        uploadFile(
            "E:/test", demo.getImgFile(), demo.getImgFile().getOriginalFilename());
        return true;
    }
    
    @Override
    public boolean uploadFile(String destinationDir, MultipartFile file, String filename) throws Exception{
         logger.info("文件长度: " + file.getSize()); 
         logger.info("文件类型: " + file.getContentType()); 
         logger.info("文件名称: " + file.getName()); 
         logger.info("文件原名: " + file.getOriginalFilename()); 
         logger.info("========================================"); 
         try {   
             SaveFileFromInputStream(file.getInputStream(), destinationDir, filename);   
         } catch (IOException e) {   
             logger.info(e.getMessage());   
             return false;   
         }   
        return true;
    }
     
     /**保存文件  
           * @param stream  
           * @param path  
           * @param filename  
           * @throws IOException  
         */ 
         private void SaveFileFromInputStream(InputStream stream,String path,String filename) 
               throws IOException {         
               FileOutputStream outputStream = new FileOutputStream( path + "/"+ filename);   
           int byteCount = 0;
           byte[] bytes = new byte[1024];
           while ((byteCount = stream.read(bytes)) != -1){
                outputStream.write(bytes, 0, byteCount);
           }
           outputStream.close();   
           stream.close();  
         }
}