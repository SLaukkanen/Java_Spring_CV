package suvi.cv.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Language")
public class LanguageImpl implements Language{
	
	@Column(name = "lang")
	@Basic(optional = false)
	@Id
	@Size(min = 1, max = 50)
	@Pattern(regexp = "\\w\\s\\")
	private String lang;
	
	@Column(name="level")
	@Basic(optional = true)
	@Size(min = 1, max = 100)
	@Pattern(regexp = "\\w\\s\\d\\,\\.\\-\\:\\;")
	private String lvl;

	public LanguageImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LanguageImpl(String lang, String lvl) {
		super();
		this.lang = lang;
		this.lvl = lvl;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

	@Override
	public String toString() {
		return "LanguageImpl [lang=" + lang + ", lvl=" + lvl + "]";
	}
	
}
