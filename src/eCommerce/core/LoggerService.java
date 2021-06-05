package eCommerce.core;

import eCommerce.entities.concretes.User;

public interface LoggerService {
	void mailLog(User user);
}
