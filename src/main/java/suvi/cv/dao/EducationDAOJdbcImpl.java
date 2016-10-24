package suvi.cv.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import suvi.cv.bean.Data;
import suvi.cv.bean.Education;

@Repository
public class EducationDAOJdbcImpl implements EducationDAO {
	
	@Inject
private JdbcTemplate jdbcTemp;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemp;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	
public List<Education> findAll() {
		
		String sql = "SELECT id, school, degree, major, minors, start_year, finish_year, date_graduation, description FROM Education;";
		RowMapper<Education> mapper = new EducationRowMapper();
		//Data data = (Data) jdbcTemp.query(sql,mapper);
		List<Education> edu = jdbcTemp.query(sql, mapper);

		return edu;
	}

}
