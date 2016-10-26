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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import suvi.cv.bean.Education;

@Repository
public class EducationDAOJdbcImpl implements EducationDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add(Education edu) {
		final String sql = "INSERT INTO Education(school, degree, major, minors, start_year, finish_year, date_graduation, description) VALUES(?,?,?,?,?,?,?,?);";

		final String school = edu.getSchool();
		final String degree = edu.getDegree();
		final String major = edu.getMajor();
		final String minors = edu.getMinors();
		final String startYear = edu.getStartYear();
		final String finish_year = edu.getFinishYear();
		final String dateGraduation = edu.getDateGraduation();
		final String description = edu.getDescription();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, new String[] {"id"});
				ps.setString(1, school);
				ps.setString(2, degree);
				ps.setString(3, major);
				ps.setString(4, minors);
				ps.setString(5, startYear);
				ps.setString(6, finish_year);
				ps.setString(7, dateGraduation);
				ps.setString(8, description);
			
				return ps;
			}
		}, idHolder);
		
		edu.setId(idHolder.getKey().intValue());
	}
	
	public List<Education> findAll() {
		
		String sql = "SELECT id, school, degree, major, minors, start_year, finish_year, date_graduation, description FROM Education;";
		RowMapper<Education> mapper = new EducationRowMapper();
		List<Education> edu = jdbcTemplate.query(sql, mapper);

		return edu;
	}
	
	public Education find(int id){
		String sql = "SELECT id, school, degree, major, minors, start_year, finish_year, date_graduation, description FROM Education WHERE id = ?";
		Object[] parametres = new Object[] {id};
		RowMapper<Education> mapper = new EducationRowMapper();

		Education edu;
		try {
			edu = jdbcTemplate.queryForObject(sql, parametres, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new DataNotFoundExeption(e);
		}
		return edu;

	}
	
	public void delete(int id){
		final String sql = "DELETE FROM Education WHERE id = ?";
		final int fId = id;
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, fId);
				ps.executeUpdate();
				return ps;
					
			};
		
		});
	}
	
	public void update(Education edu) {
		
		delete(edu.getId());
		
		add(edu);
		
	}

}
