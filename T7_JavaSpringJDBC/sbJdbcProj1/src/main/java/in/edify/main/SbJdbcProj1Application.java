package in.edify.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.edify.main.dao.UserDao;
import in.edify.main.entities.User;

@SpringBootApplication
public class SbJdbcProj1Application implements CommandLineRunner {
	
	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SbJdbcProj1Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//************ insert ********
		
		User user1 = new User(1001, "naveen@gmail.com", "naveen", "1234");

		boolean insertStatus = userDao.createUser(user1);
		
		if(insertStatus) {
			System.out.println("User Data Inserted");
		}
		else {
			System.out.println("User Data Inserted failed");
		}
		
		//************* update ***********
		
		User userToUpdate = new User(1003, "naveen_updated@gmail.com", "naveen_updated", "1234");
		boolean updateStatus = userDao.updateUser(userToUpdate);
		if(updateStatus) {
			System.out.println("User update");
		}
		else {
			System.out.println("One recored update fail");
		}
		
		//************* update1 ***********
		
		User user2 =userDao.getUserById(1001);
		user2.setEmail("n.naveenreddy45@gmail.com");
		
		boolean updateStatus1 = userDao.updateUser(user2);
		if(updateStatus1) {
			System.out.println("User update");
		}
		else {
			System.out.println("One recored update fail");
		}
		
		//**********delete*************
		
		boolean deleteStatus = userDao.deleteUser(1001);
		if(deleteStatus) {
			System.out.println("one record delete");
		}
		else {
			System.out.println("One recored delete fail");
		}
		
		//********* get user by id ********
		
		User user3 = userDao.getUserByUser(1002);
		System.out.println("*************************");
		System.out.println("User email:" +user3.getEmail());
		System.out.println("User name:" +user3.getName());
		System.out.println("User password:" +user3.getPassword());
		System.out.println("*************************");
		
		//********* get user by id more than one data * List Using * ********
		
		List<User> usersData = userDao.getUsersData();
		
		System.out.println("*************************");
		for(User user: usersData) {
			System.out.println("User Id: "+ user.getId());
			System.out.println("User email:" +user.getEmail());
			System.out.println("User name:" +user.getName());
			System.out.println("User password:" +user.getPassword());
			System.out.println("*************************");
		}
		//********* using array inserting multiple data ********
		User[] users = { 
				new User(1005, "varma@gmail.com", "varma", "1234"),
				new User(1006, "varma1@gmail.com", "varma1", "1234"),
				new User(1007, "varma2@gmail.com", "varma2", "1234")
		};
		
		for(User user: users) {
			boolean status = userDao.createUser(user);
			if(status) {
				System.out.println("User Data " + user.getName() + " data inserted");
			}
			else {
				System.out.println("User Data " + user.getName() + " data insertion failed");
			}
		}
	}

}
