package com.neusoft.index.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.neusoft.index.service.IndexService;

@Repository("indexDaoImpl")
public class IndexDaoImpl implements IndexDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List getAllZhuBo() {
		 StringBuffer sb = new StringBuffer();
		 sb.append(" SELECT t.zhubo_name zhuBoName,t.introduce,t.imgdir imgDir,t.url FROM TT_ZHUBO_INFO_T t ");
		 try {
			 return jdbcTemplate.queryForList(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List QueryInfosByParm(String parm) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT t.zhubo_name,t.introduce,t.imgdir,t.url FROM TT_ZHUBO_INFO_T t where t.keyword like %?% ");
		 try {
			 return jdbcTemplate.queryForList(sb.toString(),parm);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
