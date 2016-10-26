package suvi.cv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import suvi.cv.bean.WorkExperience;
import suvi.cv.bean.WorkExperienceImpl;

public class WorkExperienceRowMapper implements RowMapper<WorkExperience>{
	public WorkExperience mapRow(ResultSet rs, int rowNum) throws SQLException {
		WorkExperience workExp = new WorkExperienceImpl();
		
		workExp.setId(rs.getInt("id"));
		workExp.setWorkplace(rs.getString("workplace"));		
		workExp.setPosition(rs.getString("position"));
		workExp.setStartDate(rs.getString("start_date"));
		workExp.setFinishDate(rs.getString("finish_date"));
		workExp.setDescription(rs.getString("description"));
		
		return workExp;
	}

}
