package cdot.nccs.homepage.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cdot.nccs.homepage.model.User;
import cdot.nccs.homepage.repository.UserRepository;

@Service
public class implUser implements UserService{
	@Autowired
	UserRepository ur;

	@Override
	public List<User> getAUser() {
		return ur.findAll();
	}
	@Override
	public void saveUser(User user) {
		this.ur.save(user);
	}

	@Override
	public User getUserById(String name){
		Optional<User> optional=ur.findByName(name);
		User user = null;
		if(optional.isPresent()) {
			user = optional.get();
		}
		return user;
	}
	@Override
	public User getUserByMail(String mail) {
		Optional<User> optional=ur.findByMail(mail);
		User user = null;
		if(optional.isPresent()) {
			user = optional.get();
		}
		return user;
	}
}
