package suvi.cv.dao;

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
	
public Data getData() {
		
		String sql = "SELECT first_name, last_name, birth_day, email, address, area_code, city, heading, summary FROM Data;";
		RowMapper<Data> mapper = new DataRowMapper();
		Data data = (Data) jdbcTemp.query(sql,mapper);

		return data;
	}
	

}
