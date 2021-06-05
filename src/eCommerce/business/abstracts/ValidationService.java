package eCommerce.business.abstracts;

import eCommerce.entities.concretes.User;

public interface ValidationService {
	boolean checkIfRealPerson(User user);
}
