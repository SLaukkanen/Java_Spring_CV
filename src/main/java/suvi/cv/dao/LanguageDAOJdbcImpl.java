package suvi.cv.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import suvi.cv.bean.Language;

@Repository
public class LanguageDAOJdbcImpl implements LanguageDAO{
	
	@Inject
	private JdbcTemplate jdbcTemp;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemp;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	
	public List<Language> findAll() {
		
		String sql = "SELECT lang, level FROM Language;";
		RowMapper<Language> mapper = new LanguageRowMapper();
		List<Language> lang = jdbcTemp.query(sql, mapper);

		return lang;
	}

}
