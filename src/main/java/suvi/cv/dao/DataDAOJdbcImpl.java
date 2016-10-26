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

import suvi.cv.bean.Data;

@Repository
public class DataDAOJdbcImpl implements DataDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemp) {
		this.jdbcTemplate = jdbcTemp;
	}
	
	public void add(Data d) {
		final String sql = "INSERT INTO Data(first_name, last_name, birth_day, email, address, area_code, city, phone, heading, summary) VALUES(?,?,?,?,?,?,?,?,?,?);";

		final String firstName = d.getFirstName();
		final String lastName = d.getLastName();
		final String birthDay = d.getBirthDay();
		final String email = d.getEmail();
		final String address = d.getAddress();
		final String areaCode = d.getAreaCode();
		final String city = d.getCity();
		final String phone = d.getPhone();
		final String heading = d.getHeading();
		final String summary = d.getSummary();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, firstName);
				ps.setString(2, lastName);
				ps.setString(3, birthDay);
				ps.setString(4, email);
				ps.setString(5, address);
				ps.setString(6, areaCode);
				ps.setString(7, city);
				ps.setString(8, phone);
				ps.setString(9, heading);
				ps.setString(10, summary);
				return ps;
			}
		});

	}
	
	public List<Data> findAll() {
		
		String sql = "SELECT first_name, last_name, birth_day, email, address, area_code, city, phone, heading, summary FROM Data;";
		RowMapper<Data> mapper = new DataRowMapper();
		List<Data> data = jdbcTemplate.query(sql, mapper);

		return data;
	}
	
	public Data find(String firstName){
		String sql = "SELECT first_name, last_name, birth_day, email, address, area_code, city, phone, heading, summary FROM Data where first_name = ?";
		Object[] parametres = new Object[] {firstName};
		RowMapper<Data> mapper = new DataRowMapper();

		Data d;
		try {
			d = jdbcTemplate.queryForObject(sql, parametres, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new DataNotFoundExeption(e);
		}
		return d;

	}
	
	public void delete(String firstName){
		final String sql = "DELETE FROM Data WHERE first_name = ?";
		final String first_name = firstName;
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, first_name);
				ps.executeUpdate();
				return ps;
					
			};
		
		});
	}
	
	public void update(Data d) {
		
		delete(d.getFirstName());
		
		add(d);
		
	}

}
