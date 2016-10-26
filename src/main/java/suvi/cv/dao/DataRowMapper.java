package suvi.cv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import suvi.cv.bean.Data;
import suvi.cv.bean.DataImpl;


public class DataRowMapper implements RowMapper<Data>{
	public Data mapRow(ResultSet rs, int rowNum) throws SQLException {
		Data data = new DataImpl();
		
		data.setFirstName(rs.getString("first_name"));
		data.setLastName(rs.getString("last_name"));
		data.setBirthDay(rs.getString("birth_day"));
		data.setEmail(rs.getString("email"));
		data.setAddress(rs.getString("address"));
		data.setAreaCode(rs.getString("area_code"));
		data.setCity(rs.getString("city"));
		data.setPhone(rs.getString("phone"));
		data.setHeading(rs.getString("heading"));
		data.setSummary(rs.getString("summary"));
		
		return data;
	}

}
