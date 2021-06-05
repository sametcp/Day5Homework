package FifthDaysH0mework.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import FifthDaysH0mework.business.abstracts.UserManagerService;
import FifthDaysH0mework.dataAccess.concretes.DataAccessManager;
import FifthDaysH0mework.entities.concretes.User;

public class UserManager implements UserManagerService{
	
	List<User> users;
	//private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	String regex = "^(.+)@(.+)$";
	Pattern pattern = Pattern.compile(regex);
	
	
	
	public UserManager(DataAccessManager dataAccessManager) {
		this.users = dataAccessManager.getUsers();
	}
	
	@Override
	public void RegisterUser(User user) {
		
		if (EmailControl(user.getEmail()) == false) 
		{
			System.out.println("E-mail ba�kas� taraf�ndan kullan�l�yor.");
		} 
		else if (EmailRegexControl(user.getEmail()) == false) 
		{
			System.out.println("L�tfen ge�erli bir E-mail adresi giriniz.");
		} 
		else if (PasswordControl(user.getPassword()) == false) 
		{
			System.out.println("Parola uzunlu�u en az 6 karakter olmal�d�r.");
		} 
		else if (nameSurnameControl(user.getFirstName(), user.getLastName()) == false)
		{
			System.out.println("Ad ve Soyad verileri en az 2 karakterden olu�mal�d�r.");
		}
		
		else 
		{
			SendConfirmEmail(user.getEmail());
		}
		
	}

	@Override
	public void LoginUser(int id, String email, String password) {
		

		User user = isTheUser( id, email, password);  // isTheUser metodu, User t�r�n� return ediyor.
			
			
		
		if (user == null)
		{
			System.out.println("B�yle bir kullan�c� yok.");
		} 
		else 
		{

			if (id == user.getId() && password  == user.getPassword()) 
			{
				System.out.println("Giri� i�lemi yap�l�yor.");
			} 
			else 
			{
				System.out.println("L�tfen bilgilerinizi kontrol ediniz.");
			}
			
		}
		
	}
	
	public User isTheUser(int id, String email, String password) {
		
		for (User user : users) 
		{
			if (email == user.getEmail() && password == user.getPassword() && id == user.getId())
			{
				return user;
			}
		}
		return null;
		
	}
	
	public void SendConfirmEmail(String email) {
		
		System.out.println(email + " adl� e-mail adresine do�rulama mesaj� g�nderildi.");
		
	}

	public void ConfirmAccount(User user) {
		
		user.setConfirmed(true);
		users.add(user);
		System.out.println("Hesap do�ruland� ve kay�t tamamland�.");
		
	}
	
	
	
	public boolean nameSurnameControl(String firstName, String lastName) {
		
		if (firstName.length() < 2 || lastName.length() < 2) 
		{
			return false;
		} 
		else 
		{
			return true;
		}
		
	}

	public boolean EmailControl(String email) {     //////
		
		for (User user : users)
		{
			if (user.getEmail().equals(email))
			{
				return false;
			}
		}
		return true;
		
	}

	
	public boolean EmailRegexControl(String email) {			
		
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches() == false) {
			return false;
		} 
		else 
		{
			return true;
		}
		
	}

	public boolean PasswordControl(String password) {
		
		if (password.length() < 6) 
		{
			return false;
		} 
		else 
		{
			return true;
		}
		
	}
	
	
}
