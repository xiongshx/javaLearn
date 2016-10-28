package com.neusoft.util.Upload.control;

//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.neusoft.index.control.IndexController;
//import com.neusoft.util.Upload.bean.UploadDemoVo;
//import com.neusoft.util.Upload.service.UploadDemoService;
//
//@Controller
//@RequestMapping("/upload")
//public class UploadController {
//
//	private static Logger logger = Logger.getLogger(UploadController.class);
//	@Autowired
//	private UploadDemoService uploadDemoService;
//
//	/**
//	 * 第一种Spring Mvc上传文件，提交form表单文件到一个frame，刷新该frame，页面打印出返回的结果
//	 * 
//	 * @param request
//	 * @param demo
//	 * @return
//	 */
//	@RequestMapping(value = "/firstUpload", method = RequestMethod.POST)
//	@ResponseBody
//	public Object firstUpload(HttpServletRequest request, UploadDemoVo demo) {
//		logger.info("firstUpload info:" + demo.toString());
//		boolean flag = false;
//		// errorMessage：上传失败，则是错误信息；上传成功，则提示成功以及显示文件上传后的地址
//		String errorMessage = "";
//		try {
//			flag = uploadDemoService.uploadForm(demo);
//			errorMessage += "文件地址：http://demo.codingyun.com/demoFileDirectory/"
//					+ demo.getImgFile().getOriginalFilename();
//		} catch (Exception e) {
//			logger.error("firstUpload failed!", e);
//			errorMessage = "新增文件失败!";
//		}
//		if (flag) {
//			// 上传成功，返回到前台，调用uploadSucced()这个方法
//			return "<script>window.parent.uploadSucced('" + errorMessage
//					+ "');</script>";
//		}
//		// 上传失败，返回到前台，调用uploadFailed()这个方法
//		return "<script>window.parent.uploadFailed('" + errorMessage
//				+ "');</script>";
//	}
//}

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author typ
 * 
 */
@Controller
@RequestMapping("/uploadController")
public class UploadController {
	
	private static Logger logger = Logger.getLogger(UploadController.class);
	
	/**
	 * 进入下载界面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "upload_enter.do", method = RequestMethod.GET)
	public String enter(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		// 进入下载界面
		return "upload";
	}

	/**
	 * 具体的实现下载功能
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public void upload(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		boolean flag = false;
		// errorMessage：上传失败，则是错误信息；上传成功，则提示成功以及显示文件上传后的地址
		String errorMessage = "";
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			// 得到上传的文件
			MultipartFile mFile = multipartRequest.getFile("file");
			// 得到上传服务器的路径
			String path = request.getSession().getServletContext()
					.getRealPath("/WEB-INF/upload/");
			// 得到上传的文件的文件名
			String filename = mFile.getOriginalFilename();
			InputStream inputStream = mFile.getInputStream();
			byte[] b = new byte[1048576];
			int length = inputStream.read(b);
			path += "\\" + filename;
			// 文件流写到服务器端
			FileOutputStream outputStream = new FileOutputStream(path);
			outputStream.write(b, 0, length);
			inputStream.close();
			outputStream.close();
		} catch (Exception e) {
			logger.error("firstUpload failed!", e);
			errorMessage = "新增文件失败!";
			// 上传失败，返回到前台，调用uploadFailed()这个方法
		}
	}
}