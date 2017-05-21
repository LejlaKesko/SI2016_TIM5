package ba.actis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.actis.models.Document;
import ba.actis.repositories.DocumentRepository;

@RestController
@RequestMapping("/documents")
public class DocumentController {
	@Autowired
	private DocumentRepository documentRepository;

	
	@CrossOrigin
	@GetMapping(path="/get")
	public @ResponseBody Document getById(@RequestParam("id") Long id) {
		return documentRepository.findById(id);
	}
}