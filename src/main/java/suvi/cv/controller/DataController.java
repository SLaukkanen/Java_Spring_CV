package suvi.cv.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import suvi.cv.bean.Data;
import suvi.cv.dao.DataDAO;

@Controller
@RequestMapping(value="/")
public class DataController {
	
	@Inject
	private DataDAO dao;

	@RequestMapping(value="cv", method=RequestMethod.GET)
	public String getView(Model model) {
		Data data = dao.getData();
		model.addAttribute("data", data);
		return "index";
	}
	
}
