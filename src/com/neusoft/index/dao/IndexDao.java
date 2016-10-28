package com.neusoft.index.dao;

import java.util.List;

public interface IndexDao {
	/**
	 * 获取所有主播信息
	 * @return
	 */
	public List getAllZhuBo();
	
	/**
	 * 根据条件查询所有主播
	 * @param parm
	 * @return
	 */
	public List QueryInfosByParm(String parm);
}
