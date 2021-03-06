package ba.actis.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ba.actis.dto.LoginDataRequest;
import ba.actis.dto.LoginDataResponse;
import ba.actis.models.Role;
import ba.actis.models.User;
import ba.actis.repositories.RoleRepository;
import ba.actis.repositories.UserRepository;
import ba.actis.services.AuthService;
import ba.actis.services.JwtService;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private RoleRepository roleRepository;

	
	@CrossOrigin
	@GetMapping(path="/get")
	public @ResponseBody Role getById(@RequestParam("id") Long id) {
		return roleRepository.findById(id);
	}
	
	 @Autowired
	private AuthService _authService;
	
	@RequestMapping(path="", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<LoginDataResponse> login(@RequestBody LoginDataRequest request) {
    	try {
        	User user = _authService.checkLoginData(request.getEmail(), request.getPassword());
        	
        	if (user != null) {
        		user.setPassword(null); 
        		Long id=(long) 1;
        		Role role = roleRepository.findById(id);
        		String token=null;
        		if(user.getRoleId()==role){
        			 token= JwtService.issueToken(true,true);
        		}
        		else {
        			token = JwtService.issueToken(true,true);
        			}
        		
	            return ResponseEntity
	            		.status(HttpStatus.OK)
	                    .body(new LoginDataResponse(user, token));
        	}
        	else {
        		throw new ServiceException("");
        	}
           
    	}
    	catch (ServiceException e) {
    		return ResponseEntity
    				.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginDataResponse("Incorrect username or password."));
    	}
    }
}
