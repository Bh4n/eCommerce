package eCommerce.core;

import eCommerce.entities.concretes.User;

public class LoggerManager implements LoggerService {

	@Override
	public void mailLog(User user) {
		System.out.println("Dogrulama maili gönderildi");
		
	}
}
