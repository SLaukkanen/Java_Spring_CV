package suvi.cv.bean;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "WorkExperience")
public class WorkExperienceImpl implements WorkExperience {
	
	@Column(name="id")
	@Basic(optional = false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="workplace")
	@Basic(optional = false)
	@Size(min = 1, max = 50)
	private String workplace;
	
	@Column(name="position")
	@Basic(optional = false)
	@Size(min = 1, max = 50)
	private String position;
	
	@Column(name="start_date")
	@Basic(optional = false)
	private String startDate;
	
	@Column(name="finish_date")
	@Basic(optional = true)
	private String finishDate;
	
	@Column(name="description")
	@Basic(optional = true)
	@Size(min = 1, max = 500)
	@Pattern(regexp = "\\w\\s\\d\\,\\.\\-\\:\\;")
	private String description;

	public WorkExperienceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkExperienceImpl(int id, String workplace, String position,
			String startDate, String finishDate, String description) {
		super();
		this.id = id;
		this.workplace = workplace;
		this.position = position;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "WorkExperienceImpl [id=" + id + ", workplace=" + workplace
				+ ", position=" + position + ", startDate=" + startDate
				+ ", finishDate=" + finishDate + ", description=" + description
				+ "]";
	}
	
}
