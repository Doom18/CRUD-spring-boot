package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.User;

public interface UserService {
	 List<User> getAUser();
	 void saveUser(User user);
	 User getUserById(long id);
	 void delUser(long id);
} 
