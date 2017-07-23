package gpd.spring_rest.api.service.impl;

import java.util.List;

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
		User existingUser = userRepo.findOne(id);
		if (existingUser == null) {
			throw new NotFoundException("user with id:"+id+" does not exist");
		}
		return existingUser;
	}
	@Transactional
	@Override
	public User createUser(User user) {
		User existingUser = userRepo.findOneByEmail(user.getEmail());
		if (existingUser != null) {
			throw new BadRequestExceptions("user with email:"+existingUser.getEmail()+" already exists");
		}
		return userRepo.createUser(user);
	}
	@Transactional
	@Override
	public User updateUser(String id, User user) {
		User existingUser = userRepo.findOne(id);
		if (existingUser == null) {
			throw new NotFoundException("user with id:"+id+" does not exist");
		}
		return userRepo.updateUser(user);
	}
	@Transactional
	@Override
	public void deleteUser(String id) {
		User existingUser = userRepo.findOne(id);
		if (existingUser == null) {
			throw new NotFoundException("user with id:"+id+" does not exist");
		}
		userRepo.deleteUser(existingUser);
		
	}

}
