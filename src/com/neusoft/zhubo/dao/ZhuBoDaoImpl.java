package com.neusoft.zhubo.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ZhuBoDaoImpl implements ZhuBoDao{
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void save(Map map) throws Exception {
		StringBuffer sql = new StringBuffer();
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		sql.append(" insert into TT_ZHUBO_INFO_T ");
		sql.append(" (user_id, zhuBo_name, zhuBo_real_name, gender, birth,");
		sql.append(" introduce, imgdir, zhuBo_group, if_vaild, url, ");
		sql.append(" keyword, add_date, modif_date )");
		sql.append(" Values ");
		sql.append(" (:userId, :zhuBoName, :zhuBoRealName, :gender, :birth, ");
		sql.append(" :introduce, :imgdir, :zhuBoGroup, :ifVaild, :url, ");
		sql.append(" :keyWord, :addDate, :modifDate )");
		namedParameterJdbcTemplate.update(sql.toString(), map);
	}

}
