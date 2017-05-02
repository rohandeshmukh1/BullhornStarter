
public class DbUser {
	public static User getUserById(int userId){
		User u = new User();
		//populate the user object

		if (userId==100){
			u.userId = 100;
			u.username = "Bart Simpson";
			u.email = "bart@fox.net";
			u.password = "blue123";
			u.motto = "Don't have a cow, man!";
		}else if(userId==101){
			u.userId = 101;
			u.username = "Lisa Simpson";
			u.email = "lisa@fox.net";
			u.password = "blue123";
			u.motto = "Mom! Bart's hitting me!";	
		}else{
			u.userId = 102;
			u.username = "Homer Simpson";
			u.email = "homer@fox.net";
			u.password = "blue123";
			u.motto = "mmmmm..... doughnuts!";
		}
		return u;
	}
	public static User getUserByEmail(String userEmail){
		User u = new User();
		//populate the user object

		if (userEmail.equals("bart@fox.net")){
			u.userId = 100;
			u.username = "Bart Simpson";
			u.email = "bart@fox.net";
			u.password = "blue123";
			u.motto = "Don't have a cow, man!";	
		}else if (userEmail.equals("lisa@fox.net")){
			u.userId = 101;
			u.username = "Lisa Simpson";
			u.email = "lisa@fox.net";
			u.password = "blue123";
			u.motto = "Mom! Bart's hitting me!";
		}else{
			u.userId = 102;
			u.username = "Homer Simpson";
			u.email = "homer@fox.net";
			u.password = "blue123";
			u.motto = "mmmmm..... doughnuts!";
		}

		return u;
	}
	public static User addUser(String username, String userPassword, String userEmail, String userMotto){
		User u = new User();
		//populate the user object
		u.userId = 103;
		u.username = username;
		u.email = userEmail;
		u.password = userPassword;
		u.motto = userMotto;
		return u;

	}
	public static boolean updateUser(User u){
		//this method would update the user in the database
		//and return true if successful, false otherwise
		return true;
	}
	public static boolean isValidUser(String email, String password) {
	    //at this point your code would query the database to see if this user
	    //and password are valid then return either true or false
	    //for the moment we'll assume they are valid
	    return true;
	}

}
