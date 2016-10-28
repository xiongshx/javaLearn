package com.neusoft.index.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neusoft.index.dao.IndexDao;

@Service
public class IndexServiceImpl implements IndexService {
	
	@Resource
	private IndexDao indexDao;
	
	public IndexDao getIndexDao() {
		return indexDao;
	}

	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}

	public List getAllZhuBo() {
		return indexDao.getAllZhuBo();
	}

	public List search(String parm) {
		return indexDao.QueryInfosByParm(parm);
	}

}
