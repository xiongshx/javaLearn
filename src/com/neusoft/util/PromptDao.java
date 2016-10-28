package com.neusoft.util;

public interface PromptDao {

	/**
	 * 根据错误编码和语言查询错误提示
	 * @param promptId
	 * @param lang
	 * @return
	 */
	public String queryPrompt(String promptId);
}
