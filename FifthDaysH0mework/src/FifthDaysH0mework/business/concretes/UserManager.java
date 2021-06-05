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
			System.out.println("E-mail baþkasý tarafýndan kullanýlýyor.");
		} 
		else if (EmailRegexControl(user.getEmail()) == false) 
		{
			System.out.println("Lütfen geçerli bir E-mail adresi giriniz.");
		} 
		else if (PasswordControl(user.getPassword()) == false) 
		{
			System.out.println("Parola uzunluðu en az 6 karakter olmalýdýr.");
		} 
		else if (nameSurnameControl(user.getFirstName(), user.getLastName()) == false)
		{
			System.out.println("Ad ve Soyad verileri en az 2 karakterden oluþmalýdýr.");
		}
		
		else 
		{
			SendConfirmEmail(user.getEmail());
		}
		
	}

	@Override
	public void LoginUser(int id, String email, String password) {
		

		User user = isTheUser( id, email, password);  // isTheUser metodu, User türünü return ediyor.
			
			
		
		if (user == null)
		{
			System.out.println("Böyle bir kullanýcý yok.");
		} 
		else 
		{

			if (id == user.getId() && password  == user.getPassword()) 
			{
				System.out.println("Giriþ iþlemi yapýlýyor.");
			} 
			else 
			{
				System.out.println("Lütfen bilgilerinizi kontrol ediniz.");
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
		
		System.out.println(email + " adlý e-mail adresine doðrulama mesajý gönderildi.");
		
	}

	public void ConfirmAccount(User user) {
		
		user.setConfirmed(true);
		users.add(user);
		System.out.println("Hesap doðrulandý ve kayýt tamamlandý.");
		
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
