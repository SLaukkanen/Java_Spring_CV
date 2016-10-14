package suvi.cv.bean;

public class DataImpl implements Data{
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String areaCode;
	private String city;
	private String phone;
	private String heading;
	private String summary;
	
	public DataImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataImpl(String firstName, String lastName, String email,
			String address, String areaCode, String city, String phone,
			String heading, String summary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
				+ ", email=" + email + ", address=" + address + ", areaCode="
				+ areaCode + ", city=" + city + ", phone=" + phone
				+ ", heading=" + heading + ", summary=" + summary + "]";
	}

}
