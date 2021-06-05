package FifthDaysH0mework.dataAccess.abstracts;

import FifthDaysH0mework.entities.concretes.User;

public interface DataAccessServices {
	
	public void add(User user);
	public void delete(User user);
	public void update(User user);
	
}
