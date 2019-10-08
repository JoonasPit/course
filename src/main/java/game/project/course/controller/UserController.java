package game.project.course.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import game.project.course.domain.SignUp;
import game.project.course.domain.User;
import game.project.course.domain.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userrepo;
	
	@GetMapping(value="/sign")
	public String signUp(Model model){
		model.addAttribute("signup", new SignUp());
		return "sign";
	}
	@RequestMapping(value = "/signuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signup") SignUp signUp, BindingResult bindingResult) {
    	if (!bindingResult.hasErrors()) { // validation errors
    		if (signUp.getPassword().equals(signUp.getPasswordCheck())) { // check password match		
	    		String pwd = signUp.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
	
		    	User newUser = new User();
		    	newUser.setPasswordHash(hashPwd);
		    	newUser.setUsername(signUp.getusername());
		    	newUser.setUserrole("USER");
		    	if (userrepo.findByusername(signUp.getusername()) == null) {
		    		userrepo.save(newUser);
		    	}
		    	else {
	    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
	    			return "sign";		    		
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
    			return "sign";
    		}
    	}
    	else {
    		return "sign";
    	}
    	return "redirect:/sign";    	
    }
}
