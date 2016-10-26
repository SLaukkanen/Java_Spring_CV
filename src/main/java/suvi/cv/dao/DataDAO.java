package suvi.cv.dao;

import java.util.List;

import suvi.cv.bean.Data;

public interface DataDAO {
	
	public abstract void add(Data d);
	
	public abstract List<Data> findAll();
	
	public abstract Data find(String firstName);
	
	public abstract void delete(String firstName);
	
	public abstract void update(Data d);

}
