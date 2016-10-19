package suvi.cv.bean;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Data")
public class DataImpl implements Data{
	
	@Column(name="first_name")
	@Basic(optional = false)
	@Id
	@Size(min = 1, max = 50)
	private String firstName;
	
	@Column(name="last_name")
	@Basic(optional = false)
	@Size(min = 1, max = 50)
	private String lastName;
	
	@Column(name="birth_day")
	@Basic(optional = true)
	@Temporal(TemporalType.DATE)
	private Date birthDay;
	
	@Column(name="email")
	@Basic(optional = false)
	@Size(min = 1, max = 50)
	@Email
	private String email;
	
	@Column(name="address")
	@Basic(optional = true)
	@Size(min = 0, max = 55)
	@Pattern(regexp = "\\w\\s\\d\\-")
	private String address;
	
	@Column(name="area_code")
	@Basic(optional = true)
	@Pattern(regexp = "\\d{5}")
	private String areaCode;
	
	@Column(name="city")
	@Basic(optional = true)
	@Size(min = 1, max = 30)
	@Pattern(regexp = "\\w\\-")
	private String city;
	
	@Column(name="phone")
	@Basic(optional = true)
	@Size(min = 1, max = 15)
	@Pattern(regexp = "\\d\\-\\+")
	private String phone;
	
	@Column(name="heading")
	@Basic(optional = true)
	@Size(min = 1, max = 30)
	@Pattern(regexp = "\\w\\s\\d\\,\\.\\-\\!\\?")
	private String heading;
	
	@Column(name="summary")
	@Basic(optional = true)
	@Size(min = 1, max = 500)
	@Pattern(regexp = "\\w\\s\\d\\,\\.\\-\\:\\;")
	private String summary;
	
	public DataImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataImpl(String firstName, String lastName, Date birthDay,
			String email, String address, String areaCode, String city,
			String phone, String heading, String summary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.email = email;
		this.address = address;
		this.areaCode = areaCode;
		this.city = city;
		this.phone = phone;
		this.heading = heading;
		this.summary = summary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "DataImpl [firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDay=" + birthDay + ", email=" + email + ", address="
				+ address + ", areaCode=" + areaCode + ", city=" + city
				+ ", phone=" + phone + ", heading=" + heading + ", summary="
				+ summary + "]";
	}

	
}
