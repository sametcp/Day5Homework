package FifthDaysH0mework.business.abstracts;

import FifthDaysH0mework.entities.concretes.User;

public interface UserManagerService {
	

	public void RegisterUser(User user);

	public void LoginUser(int id, String email, String password);

	public void SendConfirmEmail(String email);

	public void ConfirmAccount(User user);
	
}
