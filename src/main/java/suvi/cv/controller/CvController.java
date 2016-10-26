package suvi.cv.controller;

import java.util.List;
import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import suvi.cv.bean.Data;
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
@RequestMapping(value="/")
public class CvController {
	
	@Inject
	private DataDAO dDao;
	private EducationDAO eDao;
	private WorkExperienceDAO wDao;
	private SkillDAO sDao;
	private LanguageDAO lDao;

	@RequestMapping(value="cv", method=RequestMethod.GET)
	public String getView(Model model) {
		
		List<Data> data = new ArrayList<Data>(dDao.findAll());
		List<Education> edu = new ArrayList<Education>(eDao.findAll());
		List<WorkExperience> workExp = new ArrayList<WorkExperience>(wDao.findAll());
		List<Skill> skills = new ArrayList<Skill>(sDao.findAll());
		List<Language> lang = new ArrayList<Language>(lDao.findAll());
		
		model.addAttribute("data", data);
		model.addAttribute("education", edu);
		model.addAttribute("workexperience", workExp);
		model.addAttribute("skills", skills);
		model.addAttribute("languages", lang);
		
		return "index";
	}
		
}
