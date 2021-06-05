package eCommerce.adapter;

import eCommerce.GoogleAuthService.AuthService;
import eCommerce.business.abstracts.ValidationService;
import eCommerce.entities.concretes.User;

public class GoogleAuthServiceAdapter implements ValidationService {

	@Override
	public boolean checkIfRealPerson(User user) {
		AuthService googleAuthService = new AuthService();
		googleAuthService.register();
		return true;
	}
	
}
