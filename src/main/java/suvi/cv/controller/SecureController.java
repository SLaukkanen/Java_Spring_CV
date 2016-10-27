package suvi.cv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import suvi.cv.bean.Data;
import suvi.cv.bean.DataImpl;
import suvi.cv.bean.Education;
import suvi.cv.bean.EducationImpl;
import suvi.cv.bean.Language;
import suvi.cv.bean.LanguageImpl;
import suvi.cv.bean.Skill;
import suvi.cv.bean.SkillImpl;
import suvi.cv.bean.WorkExperience;
import suvi.cv.bean.WorkExperienceImpl;
import suvi.cv.dao.DataDAO;
import suvi.cv.dao.EducationDAO;
import suvi.cv.dao.LanguageDAO;
import suvi.cv.dao.SkillDAO;
import suvi.cv.dao.WorkExperienceDAO;

@Controller("/secure")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "/cv/secure")
public class SecureController {
	
	@Inject
	private DataDAO dDao;
	private EducationDAO eDao;
	private WorkExperienceDAO wDao;
	private SkillDAO sDao;
	private LanguageDAO lDao;

	
	
	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		
		return "admin";
	}
	
	
	
	// View Data
	/*@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String viewData(Model model) {
		List<Data> data = new ArrayList<Data>(dDao.findAll());
		model.addAttribute("data", data);
		
		return "data";
	}
	
	//Adding new Data	
	@RequestMapping(value="/data/new", method=RequestMethod.GET)
	public String createData(Model model) {
		Data emptyData = new DataImpl();
			
		model.addAttribute("data", emptyData);
		return "data-new";
	}
		
	@RequestMapping(value="/data/save_new", method=RequestMethod.POST)
	public String saveCreateData(@ModelAttribute(value="data") @Valid DataImpl data, BindingResult result){		
			
		if (result.hasErrors()) {
			return "data-new";
		} else {
			dDao.add(data);
			return "data";
		}
	}
	
	//Changing info in Data
	@RequestMapping(value="/data/update{firstName}", method=RequestMethod.GET)
	public String updateData(@PathVariable String firstName, Model model){
		
		Data d = dDao.find(firstName);
		model.addAttribute("data", d);
		
		return "data-update";
	}
	
	@RequestMapping(value="/data/save_update", method=RequestMethod.POST)
	public String saveUpdateData(@ModelAttribute(value="data") @Valid DataImpl data, BindingResult result){		
		
		if (result.hasErrors()) {
			return "data-update";
		} else {
			dDao.update(data);
			return "data";
		}
	}
	
	//Deleting Data
	@RequestMapping(value="/data/delete", method=RequestMethod.GET)
	public String deleteData(@PathVariable String firstName) {
		
		dDao.delete(firstName);
		
		return "data";
	}
	
	
	
	
	//View Education
	@RequestMapping(value = "/edu", method = RequestMethod.GET)
	public String viewEducation(Model model) {
		List<Education> edu = new ArrayList<Education>(eDao.findAll());
		model.addAttribute("education", edu);
		
		return "education";
	}
	
	//Adding new Education	
	@RequestMapping(value="/edu/new", method=RequestMethod.GET)
	public String createEducation(Model model) {
		Education emptyEdu = new EducationImpl();
			
		model.addAttribute("education", emptyEdu);
		return "education-new";
	}
		
	@RequestMapping(value="/edu/save_new", method=RequestMethod.POST)
	public String saveCreateEducation(@ModelAttribute(value="education") @Valid EducationImpl edu, BindingResult result){		
			
		if (result.hasErrors()) {
			return "education-new";
		} else {
			eDao.add(edu);
			return "education";
		}
	}
	
	//Changing info in Education
	@RequestMapping(value="/edu/update{id}", method=RequestMethod.GET)
	public String updateEducation(@PathVariable int id, Model model){
		
		Education edu = eDao.find(id);
		model.addAttribute("education", edu);
		
		return "education-update";
	}
	
	@RequestMapping(value="/edu/save_update", method=RequestMethod.POST)
	public String saveUpdateEducation(@ModelAttribute(value="education") @Valid EducationImpl edu, BindingResult result){		
		
		if (result.hasErrors()) {
			return "education-update";
		} else {
			eDao.update(edu);
			return "education";
		}
	}
	
	//View WorkExperience
	@RequestMapping(value = "/work", method = RequestMethod.GET)
	public String viewWorkExperience(Model model) {
		List<WorkExperience> wExp = new ArrayList<WorkExperience>(wDao.findAll());
		model.addAttribute("workexperience", wExp);
		
		return "workexperience";
	}
	
	//Changing info in WorkExperience
	@RequestMapping(value="/work/update{id}", method=RequestMethod.GET)
	public String updateWorkExperience(@PathVariable int id, Model model){
		
		WorkExperience wExp = wDao.find(id);
		model.addAttribute("workexperience", wExp);
		
		return "workexperience-update";
	}
	
	@RequestMapping(value="/work/save_update", method=RequestMethod.POST)
	public String saveUpdateWorkExperience(@ModelAttribute(value="workexperience") @Valid WorkExperienceImpl wExp, BindingResult result){		
		
		if (result.hasErrors()) {
			return "workexperience-update";
		} else {
			wDao.update(wExp);
			return "workexperience";
		}
	}
	
	//View Skills
	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String viewSkills(Model model) {
		List<Skill> skills = new ArrayList<Skill>(sDao.findAll());
		model.addAttribute("skills", skills);
		
		return "skills";
	}
	
	//Changing info in skill
	@RequestMapping(value="/skills/update{id}", method=RequestMethod.GET)
	public String updateSkill(@PathVariable int id, Model model){
		
		Skill s = sDao.find(id);
		model.addAttribute("skill", s);
		
		return "skill-update";
	}
	
	@RequestMapping(value="/skills/save_update", method=RequestMethod.POST)
	public String saveUpdateSkill(@ModelAttribute(value="skill") @Valid SkillImpl skill, BindingResult result){		
		
		if (result.hasErrors()) {
			return "skill-update";
		} else {
			sDao.update(skill);
			return "skill";
		}
	}
	
	// View Languages
	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public String viewLanguages(Model model) {
		List<Language> lang = new ArrayList<Language>(lDao.findAll());
		model.addAttribute("language", lang);
		
		return "languages";
	}
	
	//Changing info in language
	@RequestMapping(value="/languages/update{lang}", method=RequestMethod.GET)
	public String updateLanguage(@PathVariable String lang, Model model){
		
		Language l = lDao.find(lang);
		model.addAttribute("language", l);
		
		return "language-update";
	}
	
	@RequestMapping(value="/data/save_update", method=RequestMethod.POST)
	public String saveUpdateLanguage(@ModelAttribute(value="language") @Valid LanguageImpl lang, BindingResult result){		
		
		if (result.hasErrors()) {
			return "language-update";
		} else {
			lDao.update(lang);
			return "language";
		}
	}*/

}
