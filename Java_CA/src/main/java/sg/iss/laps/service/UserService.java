package sg.iss.laps.service;

import java.util.List;

import sg.iss.laps.model.User;

public interface UserService {
	// List all the methods to be used by all controllers to interact with the repository

	List<User> findAll();
	User findUserById(Long id);
	User findByUserEmail(String email);
	void saveUser(User user);

}
