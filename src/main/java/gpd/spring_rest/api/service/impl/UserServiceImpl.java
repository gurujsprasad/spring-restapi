package gpd.spring_rest.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import gpd.spring_rest.api.entity.User;
import gpd.spring_rest.api.exceptions.BadRequestExceptions;
import gpd.spring_rest.api.exceptions.NotFoundException;
import gpd.spring_rest.api.repository.UserRepository;
import gpd.spring_rest.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepo;
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<User> findAll() {
		
		return userRepo.findAll();
	}
	
	
	@Transactional(readOnly=true)
	@Override
	public User findOne(String id) {
		
		return userRepo.findOne(id).orElseThrow(() -> new NotFoundException("user with id:"+id+" does not exist"));
		
	}
	
	
	@Transactional
	@Override
	public User createUser(User user) {
		
		Optional<User> mayExists = userRepo.findOneByEmail(user.getEmail());
		
		if (mayExists.isPresent()) {
			throw  new BadRequestExceptions("user with email:"+user.getEmail()+" already exists");
		}
		return userRepo.createUser(user);
	}
	@Transactional
	@Override
	public User updateUser(String id, User user) {
		
		userRepo.findOne(id).orElseThrow(() -> new NotFoundException("user with id:"+id+" does not exist"));
		return userRepo.updateUser(user);
	}
	@Transactional
	@Override
	public void deleteUser(String id) {
		
		User existingUser = userRepo.findOne(id).orElseThrow(() -> new NotFoundException("user with id:"+id+" does not exist"));
		userRepo.deleteUser(existingUser);
		
	}

}
