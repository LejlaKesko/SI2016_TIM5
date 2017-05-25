package ba.actis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.actis.models.Speaker;
import ba.actis.models.User;
import ba.actis.repositories.SpeakerRepository;
import ba.actis.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController extends BaseRestController<User, UserRepository>{

	@Autowired
	private UserRepository userRepository;

	
	@CrossOrigin
	@GetMapping(path="/get")
	public @ResponseBody User getById(@RequestParam("id") Long id) {
		return userRepository.findKorisnikById(id);
	}
	
	@CrossOrigin
	@GetMapping(path="/results")
	public @ResponseBody List<User> getByName(@RequestParam("name") String name) {
		return userRepository.findByName(name,name);
	}
	
	@CrossOrigin
	@GetMapping(path="/reviewers")
	public @ResponseBody List<User> getReviewers() {
		return userRepository.findReviewers();
	}
	
	@RequestMapping(value="/change", method=RequestMethod.POST)
	@ResponseBody
	public String method8(@RequestParam("newpassword") String newpassword, @RequestParam("oldpassword") String oldpassword){
		userRepository.resetPassword(newpassword, oldpassword);
		return "succes";
	}
	
}
