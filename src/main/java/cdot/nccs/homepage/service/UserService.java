package cdot.nccs.homepage.service;

import java.util.List;

import cdot.nccs.homepage.model.User;

public interface UserService {
	 List<User> getAUser();
	 void saveUser(User user);
	 User getUserById(String name);
	 User getUserByMail(String mail);
} 
