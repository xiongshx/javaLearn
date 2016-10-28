package com.neusoft.zhubo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neusoft.util.CommonUtil;
import com.neusoft.util.MapUtils;
import com.neusoft.util.StringUtil;
import com.neusoft.zhubo.bean.ZhuBo;
import com.neusoft.zhubo.dao.ZhuBoDao;

@Service
public class ZhuBoServiceImpl implements ZhuBoService  {
	
	@Resource
	private ZhuBoDao zhuBoDao;
	
	public ZhuBoDao getZhuBoDao() {
		return zhuBoDao;
	}

	public void setZhuBoDao(ZhuBoDao zhuBoDao) {
		this.zhuBoDao = zhuBoDao;
	}

	public void addZhuBo(ZhuBo zhuBo) throws Exception{
		Map map = new  HashMap();
		zhuBo.setAddDate(new Date());
		zhuBo.setIfVaild("0");
		zhuBo.setUserId(CommonUtil.randomUUID());
		map = MapUtils.java2Map(zhuBo);
		zhuBoDao.save(map);
	}
}
