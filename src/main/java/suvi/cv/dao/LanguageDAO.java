package suvi.cv.dao;

import java.util.List;

import suvi.cv.bean.Language;

public interface LanguageDAO {
	
	public abstract List<Language> findAll();

}
