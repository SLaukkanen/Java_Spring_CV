package suvi.cv.dao;

import java.util.List;

import suvi.cv.bean.Education;

public interface EducationDAO {
	
	public abstract void add(Education edu);
	
	public abstract List<Education> findAll();
	
	public abstract Education find(int id);
	
	public abstract void delete(int id);
	
	public abstract void update(Education edu);

}
