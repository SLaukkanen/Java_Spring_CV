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
import suvi.cv.bean.WorkExperience;
import suvi.cv.dao.DataDAO;
import suvi.cv.dao.EducationDAO;
import suvi.cv.dao.WorkExperienceDAO;

@Controller
@RequestMapping(value="/")
public class DataController {
	
	@Inject
	private DataDAO dao;
	private EducationDAO eDao;
	private WorkExperienceDAO wDao;

	@RequestMapping(value="cv", method=RequestMethod.GET)
	public String getView(Model model) {
		
		List<Data> data = new ArrayList<Data>(dao.findAll());
		List<Education> edu = new ArrayList<Education>(eDao.findAll());
		List<WorkExperience> workExp = new ArrayList<WorkExperience>(wDao.findAll());
		
		model.addAttribute("data", data);
		model.addAttribute("education", edu);
		model.addAttribute("workexperience", workExp);
		
		return "index";
	}
		
}
