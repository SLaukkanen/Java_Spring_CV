package suvi.cv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import suvi.cv.bean.Language;

@Repository
public class LanguageDAOJdbcImpl implements LanguageDAO{
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add(Language l) {
		final String sql = "INSERT INTO Language(lang, level) VALUES(?,?);";

		final String lang = l.getLang();
		final String lvl = l.getLvl();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, lang);
				ps.setString(2, lvl);
				
				return ps;
			}
		});

	}
	
	public List<Language> findAll() {
		
		String sql = "SELECT lang, level FROM Language;";
		RowMapper<Language> mapper = new LanguageRowMapper();
		List<Language> lang = jdbcTemplate.query(sql, mapper);

		return lang;
	}
	
	public Language find(String lang){
		String sql = "SELECT lang, level FROM Language where lang = ?";
		Object[] parametres = new Object[] {lang};
		RowMapper<Language> mapper = new LanguageRowMapper();

		Language l;
		try {
			l = jdbcTemplate.queryForObject(sql, parametres, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new DataNotFoundExeption(e);
		}
		return l;

	}
	
	public void delete(String lang){
		final String sql = "DELETE FROM Language WHERE lang = ?";
		final String fLang = lang;
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, fLang);
				ps.executeUpdate();
				return ps;
					
			};
		
		});
	}
	
	public void update(Language l) {
		
		delete(l.getLang());
		
		add(l);
		
	}

}
