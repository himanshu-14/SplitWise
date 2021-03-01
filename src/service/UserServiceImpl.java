package service;

import billsharing.model.User;
import billsharing.repository.UserRepository;

public class UserServiceImpl {
	public static void createUser(String username, String emailId) {
		UserRepository.userMap.put(emailId, new User(username, emailId));
	}

}
