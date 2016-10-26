package suvi.cv.bean;

public interface Education {
	
	public abstract int getId();
	
	public abstract void setId(int id);
	
	public abstract String getSchool();
	
	public abstract void setSchool(String school);
	
	public abstract String getDegree();
	
	public abstract void setDegree(String degree);
	
	public abstract String getMajor();
	
	public abstract void setMajor(String major);
	
	public abstract String getMinors();
	
	public abstract void setMinors(String minors);
	
	public abstract String getStartYear();
	
	public abstract void setStartYear(String startYear);
	
	public abstract String getFinishYear();
	
	public abstract void setFinishYear(String finishYear);
	
	public abstract String getDateGraduation();
	
	public abstract void setDateGraduation(String dateGraduation);
	
	public abstract String getDescription();
	
	public abstract void setDescription(String description);

}
