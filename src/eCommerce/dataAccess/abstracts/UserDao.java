package eCommerce.dataAccess.abstracts;

import java.util.List;

import eCommerce.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	List<User> getAll();
	User getUser(String email);
	void logIn(User user);
}
