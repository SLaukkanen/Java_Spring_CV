package suvi.cv.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller("/secure")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping(value = "/secure")
public class SecureController {
	
	
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		
		return "secure/admin";
	}
	

}
