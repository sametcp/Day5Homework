package FifthDaysH0mework.core.concretes;

import FifthDaysH0mework.core.abstracts.googleAuthService;
import FifthDaysH0mework.googleAuthenticator.GoogleAuth;

public class googleAuthAdapter implements googleAuthService{
	
	//GoogleAuth bilgilerini ve metotlarýný kullanabilmek için buradan iþleri yürütüyorum. oraya baðýmlý kalmamak amacým.
	//bu kýsým yerine baþka bilgiler gelirse, buraya da baðýmlý olmamak için service interface'ine implemente ederek
	//baðýmlýlýðý minimalize ediyorum. çaðýrýrsam service ile çaðýrýcam.
	
	@Override
	public void googleAuth(String email) {
		
		GoogleAuth auth = new GoogleAuth();
		auth.SignUpGoogle(email);
		
	}
	
	
	
}
