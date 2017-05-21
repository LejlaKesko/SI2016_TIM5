package ba.actis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return userRepository.findById(id);
	}
}