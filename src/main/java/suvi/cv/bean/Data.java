package suvi.cv.bean;

import java.util.Date;

public interface Data {
	
public abstract int getId();
	
	public abstract void setId(int id);
	
	public abstract String getFirstName();
	
	public abstract void setFirstName(String firstName);
	
	public abstract String getLastName();
	
	public abstract void setLastName(String lastName);
	
	public abstract Date getBirthDay();
	
	public abstract void setBirthDay(Date birthDay);
	
	public abstract String getEmail();
	
	public abstract void setEmail(String email);
	
	public abstract String getAddress();
	
	public abstract void setAddress(String address);
	
	public abstract String getAreaCode();
	
	public abstract void setAreaCode(String areaCode);
	
	public abstract String getCity();
	
	public abstract void setCity(String city);
	
	public abstract String getPhone();
	
	public abstract void setPhone(String phone);
	
	public abstract String getHeading();
	
	public abstract void setHeading(String heading);
	
	public abstract String getSummary();
	
	public abstract void setSummary(String summary);
}