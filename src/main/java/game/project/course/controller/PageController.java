package game.project.course.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import game.project.course.domain.Comment;
import game.project.course.domain.CommentRepository;
import game.project.course.domain.Score;
import game.project.course.domain.ScoreRepository;
import game.project.course.domain.UserRepository;
import game.project.course.domain.User;
import game.project.course.*;
@Controller
public class PageController {
	
	@Autowired
	private ScoreRepository scoreRepo;
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private CommentRepository commentRepository;
	@RequestMapping(value="/test")
	public String justTesting() {
		return "test";
	}
	
	@RequestMapping(value="/")
	public String sayHe() {
		return "index";
	}
	@RequestMapping(value="/game")
	public String gameTetris(Model model) {
		model.addAttribute("score", new Score());
		return "game";
	}
	@PreAuthorize("hasAuthority('ADMIN','USER')")
	@RequestMapping(value="/leaderboard", method = RequestMethod.GET)
	public String getLeaderboard(Model model) {
		model.addAttribute("score",scoreRepo.findByOrderByScoreDesc());
		return "leaderboard";
	}	
	//REST
	@RequestMapping(value ="/scores", method = RequestMethod.GET)
	public @ResponseBody List<Score> scoreRest(){
		return (List<Score>) scoreRepo.findAll();
	}
	// REST
	@RequestMapping(value ="/users", method = RequestMethod.GET)
	public @ResponseBody List<User> userRest(){
		return (List<User>) urepo.findAll();
	}
	
	@RequestMapping(value= "/login")
	public String userLogin(){
		return "login";
	}
	@GetMapping(value= "/comments")
	public String getCommentPage(Model model,Authentication authentication) {
		model.addAttribute("comments",commentRepository.findAll());
		return "comments";
	}
	@PreAuthorize("hasAuthority('ADMIN', 'USER')")
	@GetMapping(value="/delete/{id}")
	public String commentDelete(@PathVariable("id") Long id, Model model) {
		commentRepository.deleteById(id);
		return "redirect:/comments";
	}
	@PostMapping(value = "/submitscore")
	public String submitScore(Authentication authentication, @RequestParam("runscore") int score) {
		try{
			String username = authentication.getName();
			if(username.equals(null) || username == "" || username == null || username.equals(""))
			{throw new NullPointerException();
				}
			else {
			Score currentScore = new Score(username, score);
			scoreRepo.save(currentScore);
			}
			return "redirect:/leaderboard";
			}
		catch(Exception NullPointerException){return "redirect:./sign";}
	}
	@PostMapping(value = "/postcomment")
	public String postComment(Authentication authentication, @RequestParam("usercomment") String comment) {
			
		try {
			String username = authentication.getName();
			Long commentid = null;
			Comment thisComment = new Comment(commentid, comment,username);
			commentRepository.save(thisComment);
			return "redirect:/comments";
		}
		catch (Exception NullPointerException){return "redirect:/sign";}
		
	}
	@PostMapping(value ="/alteredcomment")
	public String alteredComment(Authentication authentication,@RequestParam("commentid") Long commentid ,@RequestParam("usercomment") String comment) {
		try {
			String username = authentication.getName();	
			Comment thisComment = new Comment(commentid,comment,username);
			commentRepository.save(thisComment);
			return "redirect:/comments";
		}
		catch (Exception NullPointerException){return "redirect:/sign";}
	}
	
	@GetMapping(value = "/editcomment/{id}")
	public String editUserComment(@PathVariable("id") Long id, Model model) {
		model.addAttribute("comment", commentRepository.findById(id));
		return "editcomment";
	}
	
	@PostMapping(value ="/edicomment/{id}")
	// Fix editing comment, make it not save new comment with newid
	// currently updates by saving as fully new comment
	public String postEdit(@PathVariable("id") Long id) {
		return "/comments";
	}
}
