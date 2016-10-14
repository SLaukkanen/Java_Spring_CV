package suvi.cv.dao;

import java.util.List;

import suvi.cv.bean.Data;

public interface DataDAO {
	
	public abstract List<Data> findAll();

}
