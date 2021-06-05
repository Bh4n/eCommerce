package eCommerce.business.concretes;


import java.util.List;
import java.util.Scanner;

import eCommerce.business.abstracts.UserService;
import eCommerce.business.abstracts.ValidationService;
import eCommerce.core.LoggerService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {
	static Scanner scan = new Scanner(System.in);
	private ValidationService validationService;
	private UserDao dao;
	private LoggerService loggerService;



	public UserManager(ValidationService validationService, UserDao dao, LoggerService loggerService) {
		super();
		this.validationService = validationService;
		this.dao = dao;
		this.loggerService = loggerService;
	}

	@Override
	public void signUp(User user) {

		System.out.print("Ad�n�z� girin: ");
		user.setFirstName(scan.next());
		System.out.print("Soyad�n�z� girin: ");
		user.setLastName(scan.next());
		System.out.println("E-Mail adresinizi girin: ");
		user.seteMail(scan.next());
		System.out.println("�ifrenizi girin: ");
		user.setPasswd(scan.next());
		if (!validationService.checkIfRealPerson(user)) {
			System.out.println("Kullanici eklenemedi.");
			return;
		}
		for (User u : dao.getAll()) {
			if (u.getEMail().equals(user.getEMail())) {
				System.out.println("Kullanici zaten kayitli");
				return;
			}
			dao.add(user);
			loggerService.mailLog(user);
			System.out.println("Kullanici ba�ar�yla kay�t oldu.");
		}

	}

	@Override
	public void signIn(User user) {
		if (user.getEMail() != null) {
			if (validationService.checkIfRealPerson(user)) {
				System.out.println("Giri� ba�ar�l�.\nHo�geldiniz: " + user.getFirstName()+" "+user.getLastName());
			}else {
				System.out.println("Kullanici eklenemedi.");
			}
		}
		System.out.println("E-Mail bo� ge�ilemez");
	}

	@Override
	public User getUser(String email) {
		return dao.getUser(email);

	}

	@Override
	public List<User> getAll() {
		
		return dao.getAll();
	}

}
