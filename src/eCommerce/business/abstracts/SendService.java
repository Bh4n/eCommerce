package eCommerce.business.abstracts;

import eCommerce.entities.concretes.User;

public interface SendService{
	void mailSend(User user);
}
