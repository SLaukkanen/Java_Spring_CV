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

@Controller("/secure/tools")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "/secure/tools")
public class ToolsController {
	
	@Inject
	private DataDAO dDao;
	
	@Inject
	private EducationDAO eDao;
	
	@Inject
	private WorkExperienceDAO wDao;
	
	@Inject
	private SkillDAO sDao;
	
	@Inject
	private LanguageDAO lDao;
	
	// View Data
	@RequestMapping(value = "/data", method = RequestMethod.GET)
		public String viewData(Model model) {
			List<Data> data = new ArrayList<Data>(dDao.findAll());
			model.addAttribute("data", data);
			
			return "secure/tools/data";
		}
		
		//Adding new Data	
		@RequestMapping(value="/data/new", method=RequestMethod.GET)
		public String createData(Model model) {
			Data emptyData = new DataImpl();
				
			model.addAttribute("data", emptyData);
			return "secure/tools/data-new";
		}
			
		@RequestMapping(value="/data/save_new", method=RequestMethod.POST)
		public String saveCreateData(@ModelAttribute(value="data") DataImpl data, BindingResult result){		
				
			dDao.add(data);
			/*if (result.hasErrors()) {
				return "secure/tools/data-new";
			} else {
				dDao.add(data);
				return "secure/tools/data";
			}*/
			return "secure/tools/data";
		}
		
		//Changing info in Data
		@RequestMapping(value="/data/update/{firstName}", method=RequestMethod.GET)
		public String updateData(@PathVariable String firstName, Model model){
			
			Data d = dDao.find(firstName);
			model.addAttribute("data", d);
			
			return "secure/tools/data-update";
		}
		
		@RequestMapping(value="/data/save_update", method=RequestMethod.POST)
		public String saveUpdateData(@ModelAttribute(value="data") @Valid DataImpl data, BindingResult result, Model model){		
			
			if (result.hasErrors()) {
				model.addAttribute("data", data);
				return "secure/tools/data-update";
			} else {
				dDao.update(data);
				return "secure/tools/data";
			}
		}
		
		//Deleting Data
		@RequestMapping(value="/data/delete/{firstName}", method=RequestMethod.POST)
		public String deleteData(@PathVariable String firstName) {
			
			dDao.delete(firstName);
			
			return "redirect:../../data";
		}
		
		
		
		
		
		//View Education
		@RequestMapping(value = "/edu", method = RequestMethod.GET)
		public String viewEducation(Model model) {
			List<Education> edu = new ArrayList<Education>(eDao.findAll());
			model.addAttribute("education", edu);
			
			return "secure/tools/education";
		}
		
		//Adding new Education	
		@RequestMapping(value="/edu/new", method=RequestMethod.GET)
		public String createEducation(Model model) {
			Education emptyEdu = new EducationImpl();
				
			model.addAttribute("education", emptyEdu);
			return "secure/tools/education-new";
		}
			
		@RequestMapping(value="/edu/save_new", method=RequestMethod.POST)
		public String saveCreateEducation(@ModelAttribute(value="education") @Valid EducationImpl edu, BindingResult result){		
				
			if (result.hasErrors()) {
				return "secure/tools/education-new";
			} else {
				eDao.add(edu);
				return "secure/tools/education";
			}
		}
		
		//Changing info in Education
		@RequestMapping(value="/edu/update/{id}", method=RequestMethod.GET)
		public String updateEducation(@PathVariable int id, Model model){
			
			Education edu = eDao.find(id);
			model.addAttribute("education", edu);
			
			return "secure/tools/education-update";
		}
		
		@RequestMapping(value="/edu/save_update", method=RequestMethod.POST)
		public String saveUpdateEducation(@ModelAttribute(value="education") @Valid EducationImpl edu, BindingResult result){		
			
			if (result.hasErrors()) {
				return "secure/tools/education-update";
			} else {
				eDao.update(edu);
				return "secure/tools/education";
			}
		}
		
		//Deleting Education
		@RequestMapping(value="/edu/delete/{id}", method=RequestMethod.POST)
		public String deleteEducation(@PathVariable int id) {
			
			eDao.delete(id);
			
			return "redirect:../../edu";
		}		
		
		
		
		//View WorkExperience
		@RequestMapping(value = "/work", method = RequestMethod.GET)
		public String viewWorkExperience(Model model) {
			List<WorkExperience> wExp = new ArrayList<WorkExperience>(wDao.findAll());
			model.addAttribute("workexperience", wExp);
			
			return "secure/tools/workexperience";
		}
		
		//Adding new WorkExperience	
		@RequestMapping(value="/work/new", method=RequestMethod.GET)
		public String createWorkExperience(Model model) {
			WorkExperience emptyWExp = new WorkExperienceImpl();
				
			model.addAttribute("workexperience", emptyWExp);
			return "secure/tools/workexperience-new";
		}
			
		@RequestMapping(value="/work/save_new", method=RequestMethod.POST)
		public String saveCreateWorkExperience(@ModelAttribute(value="workexperience") @Valid WorkExperienceImpl wExp, BindingResult result){		
				
			if (result.hasErrors()) {
				return "secure/tools/workexperience-new";
			} else {
				wDao.add(wExp);
				return "secure/tools/workexperience";
			}
		}		
		
		//Changing info in WorkExperience
		@RequestMapping(value="/work/update/{id}", method=RequestMethod.GET)
		public String updateWorkExperience(@PathVariable int id, Model model){
			
			WorkExperience wExp = wDao.find(id);
			model.addAttribute("workexperience", wExp);
			
			return "secure/tools/workexperience-update";
		}
		
		@RequestMapping(value="/work/save_update", method=RequestMethod.POST)
		public String saveUpdateWorkExperience(@ModelAttribute(value="workexperience") @Valid WorkExperienceImpl wExp, BindingResult result){		
			
			if (result.hasErrors()) {
				return "secure/tools/workexperience-update";
			} else {
				wDao.update(wExp);
				return "secure/tools/workexperience";
			}
		}
		
		//Deleting WorkExperience
		@RequestMapping(value="/work/delete/{id}", method=RequestMethod.POST)
		public String deleteWorkExperience(@PathVariable int id) {
			
			wDao.delete(id);
			
			return "redirect:../../work";
		}		
			
		
				
		
		//View Skills
		@RequestMapping(value = "/skills", method = RequestMethod.GET)
		public String viewSkills(Model model) {
			List<Skill> skills = new ArrayList<Skill>(sDao.findAll());
			model.addAttribute("skills", skills);
			
			return "secure/tools/skills";
		}
		
		//Adding new Skill	
		@RequestMapping(value="/skills/new", method=RequestMethod.GET)
		public String createSkill(Model model) {
			Skill emptySkill = new SkillImpl();
				
			model.addAttribute("skills", emptySkill);
			return "secure/tools/skill-new";
		}
			
		@RequestMapping(value="/skills/save_new", method=RequestMethod.POST)
		public String saveCreateSkill(@ModelAttribute(value="skills") @Valid SkillImpl skill, BindingResult result){		
				
			if (result.hasErrors()) {
				return "secure/tools/skill-new";
			} else {
				sDao.add(skill);
				return "secure/tools/skills";
			}
		}				
		
		//Changing info in skill
		@RequestMapping(value="/skills/update/{id}", method=RequestMethod.GET)
		public String updateSkill(@PathVariable int id, Model model){
			
			Skill s = sDao.find(id);
			model.addAttribute("skill", s);
			
			return "secure/tools/skill-update";
		}
		
		@RequestMapping(value="/skills/save_update", method=RequestMethod.POST)
		public String saveUpdateSkill(@ModelAttribute(value="skill") @Valid SkillImpl skill, BindingResult result){		
			
			if (result.hasErrors()) {
				return "secure/tools/skill-update";
			} else {
				sDao.update(skill);
				return "secure/tools/skill";
			}
		}
		
		//Deleting Skill
		@RequestMapping(value="/skills/delete/{id}", method=RequestMethod.POST)
		public String deleteSkill(@PathVariable int id) {
			
			sDao.delete(id);
			
			return "redirect:../../skills";
		}				
				
				
				
		
		// View Languages
		@RequestMapping(value = "/languages", method = RequestMethod.GET)
		public String viewLanguages(Model model) {
			List<Language> lang = new ArrayList<Language>(lDao.findAll());
			model.addAttribute("language", lang);
			
			return "secure/tools/languages";
		}
		
		//Adding new Language	
		@RequestMapping(value="/languages/new", method=RequestMethod.GET)
		public String createLanguages(Model model) {
			Language emptyLang = new LanguageImpl();
				
			model.addAttribute("languages", emptyLang);
			return "secure/tools/language-new";
		}
			
		@RequestMapping(value="/languages/save_new", method=RequestMethod.POST)
		public String saveCreateLanguages(@ModelAttribute(value="languages") @Valid LanguageImpl lang, BindingResult result){
			
			if (result.hasErrors()) {
				return "secure/tools/language-new";
			} else {
				lDao.add(lang);
				return "secure/tools/languages";
			}
		}
		
		
		//Changing info in language
		@RequestMapping(value="/languages/update/{lang}", method=RequestMethod.GET)
		public String updateLanguage(@PathVariable String lang, Model model){
			
			Language l = lDao.find(lang);
			model.addAttribute("language", l);
			
			return "secure/tools/language-update";
		}
		
		@RequestMapping(value="/languages/save_update", method=RequestMethod.POST)
		public String saveUpdateLanguage(@ModelAttribute(value="language") @Valid LanguageImpl lang, BindingResult result){		
			
			if (result.hasErrors()) {
				return "secure/tools/language-update";
			} else {
				lDao.update(lang);
				return "secure/tools/language";
			}
		}
		
		//Deleting Data
		@RequestMapping(value="/languages/delete/{lang}", method=RequestMethod.POST)
		public String deleteLanguage(@PathVariable String lang) {
			
			lDao.delete(lang);
			
			return "redirect:../../languages";
		}		
		
		

}
