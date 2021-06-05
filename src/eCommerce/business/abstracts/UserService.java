package eCommerce.business.abstracts;

import java.util.List;

import eCommerce.entities.concretes.User;

public interface UserService{
	void signIn(User user);
	void signUp(User user);
	User getUser(String email);
	List<User> getAll();
	
}
