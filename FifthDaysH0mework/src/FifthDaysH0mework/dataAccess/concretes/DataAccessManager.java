package FifthDaysH0mework.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import FifthDaysH0mework.dataAccess.abstracts.DataAccessServices;
import FifthDaysH0mework.entities.concretes.User;

public class DataAccessManager implements DataAccessServices{
	
	private List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		
		users.add(user);
		
	}

	@Override
	public void delete(User user) {
		
		users.remove(user);
		
	}

	@Override
	public void update(User user) {
		
		((DataAccessManager) users).update(user);
		
	}
	
	public void getAllUsers() {
		
		for (User user : users) {
			System.out.println(user.getFirstName() + " " + user.getLastName());
		}
		
	}
	
	
	public List<User> getUsers() {
		return users;
	}

	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
