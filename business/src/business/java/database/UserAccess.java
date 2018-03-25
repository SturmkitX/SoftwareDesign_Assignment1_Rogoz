package database;

import java.util.List;

import implementations.mysql.UserDAOImplem;
import interfaces.UserDAO;
import models.User;

public final class UserAccess {
	
	// private fields
	private static UserDAO dao = new UserDAOImplem();
	
	// make the class un-instantiable
	private UserAccess() {
		
	}
	
	public static User getUserByEmailAndPassword(String email, String password) {
		return dao.findUserByEmailAndPassword(email, password);
		
	}
	
	public static User getUserById(int id) {
		return dao.findUserById(id);
		
	}
	
	public static List<User> getAllUsers() {
		return dao.findAllUsers();
	}
	
	public static void updateUser(User user) {
		dao.updateUser(user);
	}
	
	public static void deleteUser(int id) {
		dao.deleteUser(id);
	}
}
