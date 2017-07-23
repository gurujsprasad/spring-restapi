package gpd.spring_rest.api.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import gpd.spring_rest.api.entity.User;
import gpd.spring_rest.api.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public User findOneByEmail(String email) {
		// TODO Auto-generated method stub
		TypedQuery<User> userQuery = em.createNamedQuery("User.findByEmail", User.class);
		userQuery.setParameter("pEmail", email);
		List<User> users =  userQuery.getResultList();
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
		
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<User> userQuery = em.createNamedQuery("User.findAll", User.class);
		return userQuery.getResultList();
	}

	@Override
	public User findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		 em.persist(user);
		 return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return em.merge(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		em.remove(user);
		
	}

	

}
