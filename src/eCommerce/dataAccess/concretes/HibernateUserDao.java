package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	private List<User> users;

	public HibernateUserDao() {
		users = new ArrayList<User>();
	}

	@Override
	public void add(User user) {
		System.out.println("Kullanici eklendi: " + user.getFirstName());
		users.add(user);

	}

	@Override
	public void update(User user) {
		System.out.println("Kullanici güncellendi: " + user.getFirstName());

	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanici silindi: " + user.getFirstName());

	}

	@Override
	public List<User> getAll() {
		return users;

	}

	@Override
	public User getUser(String email) {
		for (User user : users) {
			if (user.getEMail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void logIn(User user) {
		// TODO Auto-generated method stub
		
	}

}
