package FifthDaysH0mework;

import FifthDaysH0mework.business.abstracts.UserManagerService;
import FifthDaysH0mework.business.concretes.UserManager;
import FifthDaysH0mework.core.abstracts.googleAuthService;
import FifthDaysH0mework.core.concretes.googleAuthAdapter;
import FifthDaysH0mework.dataAccess.concretes.DataAccessManager;
import FifthDaysH0mework.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		 UserManagerService userManager = new UserManager(new DataAccessManager());
		
		 // Normal kayýt hesaplarý
		 User user1 = new User(1,"Samet Berk", "Þimþek","sametberk.simsek@gmail.com","123456",false);
		 User user2 = new User(2,"Ezgi","Karalý","ezgikarali55@gmail.com","1234567",false);
		 
		 
		 
		 userManager.RegisterUser(user1);
		 userManager.ConfirmAccount(user1);
		 System.out.println("----------------------------------");
		 userManager.RegisterUser(user2);
		 userManager.ConfirmAccount(user2);
		 
		 System.out.println("----------------------------------");
		 
		 // Google hesaplarý
		 googleAuthService googleAuthAdapter = new googleAuthAdapter();
		 googleAuthAdapter.googleAuth("sametberk.simsek@gmail.com");
		 
		 System.out.println("----------------------------------");
		 
		 // Register olmuþ hesaplarla giriþ
		 userManager.LoginUser(user1.getId(),user1.getEmail(),user1.getPassword());
		 userManager.LoginUser(3,user2.getEmail(), user2.getPassword());
		 
	}

}
