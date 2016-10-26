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

import suvi.cv.bean.Skill;

@Repository
public class SkillDAOJdbcImpl implements SkillDAO{
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void add(Skill s) {
		final String sql = "INSERT INTO Skill(skill, description) VALUES(?,?);";

		final String skill = s.getSkill();
		final String description = s.getDescription();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, new String[] {"id"});
				ps.setString(1, skill);
				ps.setString(2, description);
			
				return ps;
			}
		}, idHolder);
		
		s.setId(idHolder.getKey().intValue());
	}
	
	public List<Skill> findAll() {
		
		String sql = "SELECT id, skill, description FROM Skill;";
		RowMapper<Skill> mapper = new SkillRowMapper();
		List<Skill> skill = jdbcTemplate.query(sql, mapper);

		return skill;
	}
	
	public Skill find(int id){
		String sql = "SELECT id, skill, description FROM Skill WHERE id = ?";
		Object[] parametres = new Object[] {id};
		RowMapper<Skill> mapper = new SkillRowMapper();

		Skill s;
		try {
			s = jdbcTemplate.queryForObject(sql, parametres, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new DataNotFoundExeption(e);
		}
		return s;

	}
	
	public void delete(int id){
		final String sql = "DELETE FROM Skill WHERE id = ?";
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
	
	public void update(Skill s) {
		
		delete(s.getId());
		
		add(s);
		
	}

}
