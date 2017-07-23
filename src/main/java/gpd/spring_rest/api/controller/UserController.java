package gpd.spring_rest.api.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gpd.spring_rest.api.entity.User;
import gpd.spring_rest.api.service.UserService;
import gpd.spring_rest.api.constants.URi;


/*@Controller
@ResponseBody*/

@RestController
@RequestMapping(value = URi.USERS)
public class UserController {

	private UserService userService;
	UserController (UserService userService){
		this.userService = userService;
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll(){
		return userService.findAll();
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = URi.ID, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne (@PathVariable ("id") String id) {
		return userService.findOne(id);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User createUser (@RequestBody User user) {
		return userService.createUser(user);
	}
	
	
	
	@RequestMapping (value = URi.ID, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User updateUser (@PathVariable ("id") String id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	
	
	@RequestMapping (method = RequestMethod.DELETE, value = URi.ID)
	public void deleteUser (@PathVariable ("id") String id) {
		userService.deleteUser(id);
	}
}
