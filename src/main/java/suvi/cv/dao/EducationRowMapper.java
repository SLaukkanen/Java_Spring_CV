package suvi.cv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import suvi.cv.bean.Education;
import suvi.cv.bean.EducationImpl;

public class EducationRowMapper implements RowMapper<Education>{
	public Education mapRow(ResultSet rs, int rowNum) throws SQLException {
		Education edu = new EducationImpl();
		
		edu.setId(rs.getInt("id"));
		edu.setSchool(rs.getString("school"));		
		edu.setDegree(rs.getString("degree"));
		edu.setMajor(rs.getString("major"));
		edu.setMinors(rs.getString("minors"));
		edu.setStartYear(rs.getString("start_year"));
		edu.setFinishYear(rs.getString("finish_year"));
		edu.setDateGraduation(rs.getString("date_graduation"));
		edu.setDescription(rs.getString("description"));
		
		return edu;
	}

}
