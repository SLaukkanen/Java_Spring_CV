package suvi.cv.dao;

import java.util.List;

import suvi.cv.bean.Skill;

public interface SkillDAO {
	
	public abstract void add(Skill s);
	
	public abstract List<Skill> findAll();
	
	public abstract Skill find(int id);
	
	public abstract void delete(int id);
	
	public abstract void update(Skill s);

}
