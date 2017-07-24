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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import gpd.spring_rest.api.constants.URi;


/*@Controller
@ResponseBody*/

@RestController
@RequestMapping(value = URi.USERS)
@Api(tags = "USER Service")
public class UserController {

	private UserService userService;
	UserController (UserService userService){
		this.userService = userService;
	}
	
	@ApiOperation(value ="find all users", notes = "returns a list of users")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code=200, message = "success"),
			@ApiResponse(code=500, message = "internal server error")
			
	})
	public List<User> findAll(){
		return userService.findAll();
	}
	
	
	@ApiOperation(value ="find a user by ID", notes = "returns a user of given ID")
	@RequestMapping(method = RequestMethod.GET, value = URi.ID, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code=200, message = "success"),
			@ApiResponse(code=404, message = "Not Found"),
			@ApiResponse(code=500, message = "internal server error")
			
	})
	public User findOne (@PathVariable ("id") String id) {
		return userService.findOne(id);
	}
	
	
	@ApiOperation(value ="Create new user", notes = "returns created user")
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code=200, message = "success"),
			@ApiResponse(code=400, message = "Bad request"),
			@ApiResponse(code=500, message = "internal server error")
			
	})
	public User createUser (@RequestBody User user) {
		return userService.createUser(user);
	}
	
	
	@ApiOperation(value ="Update a user", notes = "returns a updated value of user")
	@RequestMapping (value = URi.ID, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code=200, message = "success"),
			@ApiResponse(code=404, message = "Not FOund"),
			@ApiResponse(code=500, message = "internal server error")
			
	})
	public User updateUser (@PathVariable ("id") String id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	
	@ApiOperation(value ="Delete a user", notes = "deletes a user")
	@RequestMapping (method = RequestMethod.DELETE, value = URi.ID)
	@ApiResponses(value = {
			@ApiResponse(code=200, message = "success"),
			@ApiResponse(code=404, message = "Not FOund"),
			@ApiResponse(code=500, message = "internal server error")
			
	})
	public void deleteUser (@PathVariable ("id") String id) {
		userService.deleteUser(id);
	}
}
