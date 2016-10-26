package suvi.cv.dao;

import java.util.List;

import suvi.cv.bean.WorkExperience;

public interface WorkExperienceDAO {
	
	public abstract void add(WorkExperience wExp);
	
	public abstract List<WorkExperience> findAll();
	
	public abstract WorkExperience find(int id);
	
	public abstract void delete(int id);
	
	public abstract void update(WorkExperience wExp);

}
