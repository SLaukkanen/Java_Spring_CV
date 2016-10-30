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

import suvi.cv.bean.WorkExperience;

@Repository
public class WorkExperienceDAOJdbcImpl implements WorkExperienceDAO{
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemp) {
		this.jdbcTemplate = jdbcTemp;
	}
	
	public void add(WorkExperience wExp) {
		final String sql = "INSERT INTO WorkExperience(workplace, position, start_date, finish_date, description) VALUES(?,?,?,?,?);";

		final String workplace = wExp.getWorkplace();
		final String position = wExp.getPosition();
		final String startDate = wExp.getStartDate();
		final String finishDate = wExp.getFinishDate();
		final String description = wExp.getDescription();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, new String[] {"id"});
				ps.setString(1, workplace);
				ps.setString(2, position);
				ps.setString(3, startDate);
				ps.setString(4, finishDate);
				ps.setString(5, description);
			
				return ps;
			}
		}, idHolder);
		
		wExp.setId(idHolder.getKey().intValue());
	}
	
	public List<WorkExperience> findAll() {
		
		String sql = "SELECT id, workplace, position, start_date, finish_date, description FROM WorkExperience;";
		RowMapper<WorkExperience> mapper = new WorkExperienceRowMapper();
		List<WorkExperience> workExp = jdbcTemplate.query(sql, mapper);

		return workExp;
	}
	
	public WorkExperience find(int id){
		String sql = "SELECT id, workplace, position, start_date, finish_date, description FROM WorkExperience WHERE id = ?;";
		Object[] parametres = new Object[] {id};
		RowMapper<WorkExperience> mapper = new WorkExperienceRowMapper();

		WorkExperience wExp;
		try {
			wExp = jdbcTemplate.queryForObject(sql, parametres, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new DataNotFoundExeption(e);
		}
		return wExp;

	}
	
	public void delete(int id){
		final String sql = "DELETE FROM WorkExperience WHERE id = ?";
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
	
	public void update(WorkExperience wExp) {
		
		delete(wExp.getId());
		
		add(wExp);
		
	}

}
