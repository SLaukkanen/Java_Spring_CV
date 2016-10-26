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
import suvi.cv.bean.Language;
import suvi.cv.bean.Skill;
import suvi.cv.bean.WorkExperience;
import suvi.cv.dao.DataDAO;
import suvi.cv.dao.EducationDAO;
import suvi.cv.dao.LanguageDAO;
import suvi.cv.dao.SkillDAO;
import suvi.cv.dao.WorkExperienceDAO;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "/secure")
public class SecureController {
	
	@Inject
	private DataDAO dDao;
	private EducationDAO eDao;
	private WorkExperienceDAO wDao;
	private SkillDAO sDao;
	private LanguageDAO lDao;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		
		return "admin";
	}
	
	
	
	// View Data
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String viewData(Model model) {
		List<Data> data = new ArrayList<Data>(dDao.findAll());
		model.addAttribute("data", data);
		
		return "data";
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
	
	// Adding new Data	
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
	
	//View WorkExperience
	@RequestMapping(value = "/work", method = RequestMethod.GET)
	public String viewWorkExperience(Model model) {
		List<WorkExperience> workExp = new ArrayList<WorkExperience>(wDao.findAll());
		model.addAttribute("workexperience", workExp);
		
		return "workexperience";
	}
	
	//View Skills
	@RequestMapping(value = "/skills", method = RequestMethod.GET)
	public String viewSkills(Model model) {
		List<Skill> skills = new ArrayList<Skill>(sDao.findAll());
		model.addAttribute("skills", skills);
		
		return "skills";
	}
	
	// View Languages
	@RequestMapping(value = "/languages", method = RequestMethod.GET)
	public String viewLanguages(Model model) {
		List<Language> lang = new ArrayList<Language>(lDao.findAll());
		model.addAttribute("languages", lang);
		
		return "languages";
	}

}
