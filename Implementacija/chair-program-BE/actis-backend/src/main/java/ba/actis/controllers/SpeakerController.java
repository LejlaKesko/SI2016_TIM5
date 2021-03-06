package ba.actis.controllers;


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

import ba.actis.exceptions.EntityNotFoundException;
import ba.actis.models.Speaker;
import ba.actis.repositories.SpeakerRepository;


@RestController
@RequestMapping("/speakers")
public class SpeakerController extends BaseRestController<Speaker, SpeakerRepository>{

	@Autowired
	private SpeakerRepository speakerRepository;

	
	@CrossOrigin
	@GetMapping(path="/get")
	public @ResponseBody Speaker getById(@RequestParam("id") Long id) {
		return speakerRepository.findById(id);
	}
}
