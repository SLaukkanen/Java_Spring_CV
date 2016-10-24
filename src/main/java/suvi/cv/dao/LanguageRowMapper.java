package suvi.cv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import suvi.cv.bean.Language;
import suvi.cv.bean.LanguageImpl;

public class LanguageRowMapper implements RowMapper<Language>{
	public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
		Language lang = new LanguageImpl();
		
		lang.setLang(rs.getString("lang"));		
		lang.setLvl(rs.getString("level"));
		
		return lang;
	}

}
