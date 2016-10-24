package suvi.cv.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import suvi.cv.bean.Data;

@Repository
public class DataDAOJdbcImpl implements DataDAO {
	
	@Inject
	private JdbcTemplate jdbcTemp;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemp;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemp) {
		this.jdbcTemp = jdbcTemp;
	}
	
	public List<Data> findAll() {
		
		String sql = "SELECT first_name, last_name, birth_day, email, address, area_code, city, phone, heading, summary FROM Data;";
		RowMapper<Data> mapper = new DataRowMapper();
		List<Data> data = jdbcTemp.query(sql, mapper);

		return data;
	}
	

}
