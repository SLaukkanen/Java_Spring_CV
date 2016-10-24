package suvi.cv.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import suvi.cv.bean.Skill;

@Repository
public class SkillDAOJdbcImpl implements SkillDAO{
	
	@Inject
	private JdbcTemplate jdbcTemp;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemp;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	
	public List<Skill> findAll() {
		
		String sql = "SELECT id, skill, description FROM Skill;";
		RowMapper<Skill> mapper = new SkillRowMapper();
		List<Skill> skill = jdbcTemp.query(sql, mapper);

		return skill;
	}

}
