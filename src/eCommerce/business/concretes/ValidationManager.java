package eCommerce.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerce.business.abstracts.ValidationService;
import eCommerce.entities.concretes.User;

public class ValidationManager implements ValidationService {

	@Override
	public boolean checkIfRealPerson(User user) {
		if (user.getFirstName().length() < 3) {
			System.out.println("Adýnýz en az 2 karakterden oluþmalýdýr.");
			return false;
		}
		if (user.getLastName().length() < 3) {
			System.out.println("Soyadýnýz en az 2 karakterden oluþmalýdýr.");
			return false;
		}
		if (user.getPasswd().length() < 6) {
			System.out.println("Parola en az 6 karakterden oluþmalýdýr");
			return false;
		}
		final Pattern regexPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = regexPattern.matcher(user.getEMail());
		if (!matcher.find()) {
			System.out.println("Incorrect E-Mail");
			return false;
		}
		return true;
	}

}
