package gpd.spring_rest.api.repository;

import java.util.List;
import java.util.Optional;

import gpd.spring_rest.api.entity.User;

public interface UserRepository {

public List<User> findAll();
	
	public Optional<User> findOne (String id);
	
	public Optional<User> findOneByEmail (String email);
	
	public User createUser (User user);
	
	public User updateUser (User user);
	
	public void deleteUser (User user);
	
}
