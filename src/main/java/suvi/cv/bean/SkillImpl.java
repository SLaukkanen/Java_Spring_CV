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
@Table(name = "Skill")
public class SkillImpl implements Skill{
	
	@Column(name = "id")
	@Basic(optional = false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="skill")
	@Basic(optional = false)
	@Size(min = 1, max = 50)
	@Pattern(regexp = "\\w\\s\\d\\,\\.\\-\\:\\;")
	private String skill;
	
	@Column(name="description")
	@Basic(optional = true)
	@Size(min = 1, max = 500)
	@Pattern(regexp = "\\w\\s\\d\\,\\.\\-\\:\\;")
	private String description;

	public SkillImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkillImpl(int id, String skill, String description) {
		super();
		this.id = id;
		this.skill = skill;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "SkillImpl [id=" + id + ", skill=" + skill + ", description="
				+ description + "]";
	}

}
