package suvi.cv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import suvi.cv.bean.Skill;
import suvi.cv.bean.SkillImpl;

public class SkillRowMapper implements RowMapper<Skill>{
	public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
		Skill skill = new SkillImpl();
		
		skill.setId(rs.getInt("id"));
		skill.setSkill(rs.getString("skill"));		
		skill.setDescription(rs.getString("description"));
		
		return skill;
	}

}
