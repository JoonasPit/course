package game.project.course.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import game.project.course.domain.Score;
import game.project.course.domain.ScoreRepository;
@Controller
public class PageController {
	
	@Autowired
	private ScoreRepository scoreRepo;
	
	@RequestMapping(value="/")
	public String sayHe() {
		return "index";
	}
	@RequestMapping(value="/game")
	public String gameTetris() {
		return "game";
	}
	@RequestMapping(value="/leaderboard", method = RequestMethod.GET)
	public String getLeaderboard(Model model) {
		model.addAttribute("score", scoreRepo.findAll());
		return "leaderboard";
	}	
	//REST
	@RequestMapping(value ="/scores", method = RequestMethod.GET)
	public @ResponseBody List<Score> scoreRest(){
		return (List<Score>) scoreRepo.findAll();
	}
	
	@RequestMapping(value= "/login")
	public String userLogin(){
		return "login";
	}
	@GetMapping(value= "/comments")
	public String getCommentPage() {
		return "comments";
	}

	
}