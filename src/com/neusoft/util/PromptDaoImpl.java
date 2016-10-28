package com.neusoft.util;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PromptDaoImpl implements PromptDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String queryPrompt(String promptId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select t.remark from PROMPT_INFO t where t.PROMPT_ID=? ");
		try {
			return jdbcTemplate.queryForObject(sql.toString(), String.class,promptId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
