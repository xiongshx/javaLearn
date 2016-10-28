package com.neusoft.zhubo.control;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.neusoft.index.control.IndexController;
import com.neusoft.util.PromptService;
import com.neusoft.zhubo.bean.ZhuBo;
import com.neusoft.zhubo.service.ZhuBoService;

/**
 * 主播相关操作
 * @author xiongshx
 *
 */
@Controller
@RequestMapping("/ZhuBoController")
public class ZhuBoController {
	private static Logger logger = Logger.getLogger(ZhuBoController.class);
	@Resource
	private PromptService promptService;
	
	@Resource
	private ZhuBoService zhuBoService;
	
	public ZhuBoService getZhuBoService() {
		return zhuBoService;
	}

	public void setZhuBoService(ZhuBoService zhuBoService) {
		this.zhuBoService = zhuBoService;
	}

	public PromptService getPromptService() {
		return promptService;
	}
	
	public void setPromptService(PromptService promptService) {
		this.promptService = promptService;
	}
	
	/**
	 * 新增主播
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addZhuBo")
	public String addZhuBo(HttpServletRequest request,HttpServletResponse response) {
		Map respMap = new HashMap();
		Map resMap = new HashMap();
		String strArgs = request.getParameter("orderJson");
		Gson gson = new Gson();		
		ZhuBo zhuBo = gson.fromJson(strArgs, ZhuBo.class);
		logger.info("新增主播开始");
		try {
			//zhuBoService.addZhuBo(zhuBo);
			respMap.put("code", "0000");
			logger.info("主播新增成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("主播新增异常！"+e);
			resMap.put("code", "0001");
			resMap.put("msg", promptService.queryPrompt("0001"));
			respMap.put("resp", resMap);
		}
		request.setAttribute("respMap", respMap);
		return "/welcome";
	}
	
	
	 @RequestMapping(value="/upload",method=RequestMethod.POST)  
	    private String fildUpload(@RequestParam(value="file",required=false) MultipartFile file,  
	            HttpServletRequest request)throws Exception{  
	          
	        //获得物理路径webapp所在路径  
	        String pathRoot = request.getSession().getServletContext().getRealPath("");  
	        String path="";  
	        if(!file.isEmpty()){  
	            //生成uuid作为文件名称  
	            String uuid = UUID.randomUUID().toString().replaceAll("-","");  
	            //获得文件类型（可以判断如果不是图片，禁止上传）  
	            String contentType=file.getContentType();  
	            //获得文件后缀名称  
	            String imageName=contentType.substring(contentType.indexOf("/")+1);  
	            path="/static/images/"+uuid+"."+imageName;  
	            file.transferTo(new File(pathRoot+path));  
	        }  
	        System.out.println(path);  
	        request.setAttribute("imagesPath", path);  
	        return "success";  
	    }  
	    //因为我的JSP在WEB-INF目录下面，浏览器无法直接访问  
	    @RequestMapping(value="/forward")  
	    private String forward(){  
	        return "index";  
	    }  
	
	/**
	 * 新增主播
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request,HttpServletResponse response) {
		return "zhubo/ZhuBoInfo";
	}
	
}
