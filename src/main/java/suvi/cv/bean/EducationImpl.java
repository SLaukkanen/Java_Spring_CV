package suvi.cv.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Education")
public class EducationImpl implements Education {
	
	@Column(name = "id")
	//@Basic(optional = false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="school")
	//@Basic(optional = false)
	@Size(min = 1, max = 50)
	@Pattern(regexp = "\\w\\s\\-")
	private String school;
	
	@Column(name="degree")
	//@Basic(optional = true)
	@Size(min = 1, max = 50)
	@Pattern(regexp = "\\w\\s\\,\\-")
	private String degree;
	
	@Column(name="major")
	//@Basic(optional = false)
	@Size(min = 1, max = 50)
	@Pattern(regexp = "\\w\\s")
	private String major;
	
	@Column(name="minors")
	//@Basic(optional = true)
	@Size(min = 0, max = 100)
	@Pattern(regexp = "\\w\\s\\,")
	private String minors;
	
	@Column(name="star_year")
	//@Basic(optional = true)
	@Pattern(regexp = "\\d{4}")
	private String startYear;
	
	@Column(name="finish_year")
	//@Basic(optional = true)
	@Pattern(regexp = "\\d{4}")
	private String finishYear;
	
	@Column(name="date_graduation")
	//@Basic(optional = true)
	@Temporal(TemporalType.DATE)
	private Date dateGraduation;
	
	@Column(name="description")
	//@Basic(optional = true)
	@Size(min = 1, max = 500)
	@Pattern(regexp = "\\w\\s\\d\\,\\.\\-\\:\\;")
	private String description;

	public EducationImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EducationImpl(int id, String school, String degree, String major,
			String minors, String startYear, String finishYear,
			Date dateGraduation, String description) {
		super();
		this.id = id;
		this.school = school;
		this.degree = degree;
		this.major = major;
		this.minors = minors;
		this.startYear = startYear;
		this.finishYear = finishYear;
		this.dateGraduation = dateGraduation;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMinors() {
		return minors;
	}

	public void setMinors(String minors) {
		this.minors = minors;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getFinishYear() {
		return finishYear;
	}

	public void setFinishYear(String finishYear) {
		this.finishYear = finishYear;
	}

	public Date getDateGraduation() {
		return dateGraduation;
	}

	public void setDateGraduation(Date dateGraduation) {
		this.dateGraduation = dateGraduation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "EducationImpl [id=" + id + ", school=" + school + ", degree="
				+ degree + ", major=" + major + ", minors=" + minors
				+ ", startYear=" + startYear + ", finishYear=" + finishYear
				+ ", dateGraduation=" + dateGraduation + ", description="
				+ description + "]";
	}
	
}
