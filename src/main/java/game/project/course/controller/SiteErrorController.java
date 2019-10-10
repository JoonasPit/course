package game.project.course.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteErrorController implements ErrorController {
	@RequestMapping(value = "/error")
		public String errorHandler() {
		
		return "error";
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}

}
