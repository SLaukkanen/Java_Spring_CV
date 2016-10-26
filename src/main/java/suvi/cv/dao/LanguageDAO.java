package suvi.cv.dao;

import java.util.List;

import suvi.cv.bean.Language;

public interface LanguageDAO {
	
	public abstract void add(Language l);
	
	public abstract List<Language> findAll();
	
	public abstract Language find(String lang);
	
	public abstract void delete(String lang);
	
	public abstract void update(Language l);

}
