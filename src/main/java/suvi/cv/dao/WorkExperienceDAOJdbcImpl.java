package suvi.cv.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import suvi.cv.bean.WorkExperience;

@Repository
public class WorkExperienceDAOJdbcImpl implements WorkExperienceDAO{
	
	@Inject
	private JdbcTemplate jdbcTemp;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemp;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	
	public List<WorkExperience> findAll() {
		
		String sql = "SELECT id, workplace, position, start_date, finish_date, description FROM WorkExperience;";
		RowMapper<WorkExperience> mapper = new WorkExperienceRowMapper();
		List<WorkExperience> workExp = jdbcTemp.query(sql, mapper);

		return workExp;
	}

}
