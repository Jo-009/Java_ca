package sg.iss.laps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.iss.laps.model.User;
import sg.iss.laps.repository.UserRepo;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo uRepo;
	
	@Override
	public List<User> findAll() {
		return uRepo.findAll();
	}
	
	@Override
	public User findUserById(Long id) {
		return uRepo.findById(id);
	}
	
	@Override
	public User findByUserEmail(String email) {
		List<User> result = new ArrayList<User>();
		result.addAll(uRepo.findByUserEmail(email));
		if(result.isEmpty() || result == null) {
			return null;
		}
		return result.get(0);
	}

	@Override
	public void saveUser(User user) {
		uRepo.saveAndFlush(user);
	}
	

}
