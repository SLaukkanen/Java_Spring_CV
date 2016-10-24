package suvi.cv.bean;

import java.util.Date;

public interface WorkExperience {
	
	public abstract int getId();
	
	public abstract void setId(int id);
	
	public abstract String getWorkplace();
	
	public abstract void setWorkplace(String workplace);
	
	public abstract String getPosition();
	
	public abstract void setPosition(String position);
	
	public abstract Date getStartDate();
	
	public abstract void setStartDate(Date startDate);
	
	public abstract Date getFinishDate();
	
	public abstract void setFinishDate(Date finishDate);
	
	public abstract String getDescription();
	
	public abstract void setDescription(String description);

}
