package com.neusoft.index.service;

import java.util.List;

public interface IndexService {
	/**
	 * 获取所有主播信息
	 * @return
	 */
	public List getAllZhuBo();

	/**
	 * 根据条件获取信息
	 * @param parm
	 * @return
	 */
	public List search(String parm);
}
