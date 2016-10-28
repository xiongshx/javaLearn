package com.neusoft.index.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neusoft.index.dao.IndexDao;
import com.neusoft.index.service.IndexService;
import com.neusoft.util.PromptService;


/**
 * 首页相关信息
 * @author xiongshx
 *
 */
@Controller
@RequestMapping("/indexController")
public class IndexController {

	private static Logger logger = Logger.getLogger(IndexController.class);

	@Resource
	private IndexService indexService;

	@Resource
	private PromptService promptService;

	public PromptService getPromptService() {
		return promptService;
	}

	public void setPromptService(PromptService promptService) {
		this.promptService = promptService;
	}

	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}
	
	/**
	 * 主页所有主播信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String indexList(HttpServletRequest request,HttpServletResponse response) {
		Map respMap = new HashMap();
		Map resMap = new HashMap();
		List userList = new ArrayList();
		logger.info("首页主播展示请求开始");
		try {
			userList = indexService.getAllZhuBo();
			respMap.put("userList", userList);
			respMap.put("code", "0000");
		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("code", "0001");
			resMap.put("msg", promptService.queryPrompt("0001"));
			respMap.put("resp", resMap);
		}
		request.setAttribute("userMap", respMap);
		logger.info("首页主播展示返回结果为：" + respMap.toString());
		return "/welcome";
	}
	
	/**
	 * 根据相关参数搜索信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request,HttpServletResponse response) {
		String parm = request.getParameter("req");
		Map respMap = new HashMap();
		Map resMap = new HashMap();
		List list = new ArrayList();
		logger.info("根据关键字搜索开始");
		try {
			list = indexService.search(parm);
			respMap.put("list", list);
			respMap.put("code", "0000");
		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("code", "0001");
			resMap.put("msg", promptService.queryPrompt("0001"));
			respMap.put("resp", resMap);
		}
		request.setAttribute("searchMap", respMap);
		logger.info("首页主播展示返回结果为：" + respMap.toString());
		return "/queryList";
	}
}
