package com.neusoft.util;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class PromptServiceImpl implements PromptService{

	private static Logger logger = Logger.getLogger(PromptServiceImpl.class);
	
	@Resource
	private PromptDao promptDao;
	
	public PromptDao getPromptDao() {
		return promptDao;
	}

	public void setPromptDao(PromptDao promptDao) {
		this.promptDao = promptDao;
	}

	public String queryPrompt(String promptId){
		StringBuffer promptBuf = new StringBuffer();
		String prompt = promptDao.queryPrompt(promptId);
		return prompt;
	}
	
	
}
