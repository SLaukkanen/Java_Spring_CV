package suvi.cv.dao;

import java.util.List;

import suvi.cv.bean.Skill;

public interface SkillDAO {
	
	public abstract List<Skill> findAll();

}
