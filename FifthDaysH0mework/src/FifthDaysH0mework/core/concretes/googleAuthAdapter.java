package FifthDaysH0mework.core.concretes;

import FifthDaysH0mework.core.abstracts.googleAuthService;
import FifthDaysH0mework.googleAuthenticator.GoogleAuth;

public class googleAuthAdapter implements googleAuthService{
	
	//GoogleAuth bilgilerini ve metotlar�n� kullanabilmek i�in buradan i�leri y�r�t�yorum. oraya ba��ml� kalmamak amac�m.
	//bu k�s�m yerine ba�ka bilgiler gelirse, buraya da ba��ml� olmamak i�in service interface'ine implemente ederek
	//ba��ml�l��� minimalize ediyorum. �a��r�rsam service ile �a��r�cam.
	
	@Override
	public void googleAuth(String email) {
		
		GoogleAuth auth = new GoogleAuth();
		auth.SignUpGoogle(email);
		
	}
	
	
	
}
