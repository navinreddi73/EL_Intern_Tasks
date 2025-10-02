package in.edify.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import in.edify.main.entities.User;
import in.edify.main.mappers.UserRowMapper;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean createUser(User user) {
		boolean status = false;
		try {
			String insert_query = "insert into users(id, name, email, password) values(?,?,?,?)";
			int cnt = jdbcTemplate.update(insert_query, user.getId(), user.getName(), user.getEmail(), user.getPassword());
			if(cnt>0) {
				status = true;
			}
			else {
				status = false;
			}
		}
		catch(Exception e){
			status = false;
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean updateUser(User user) {
		boolean status = false;
		try {
			String update_query = "update users set email=?, name=?, password=? where id=?";
			int cnt = jdbcTemplate.update(
				    update_query,
				    user.getEmail(),
				    user.getName(),
				    user.getPassword(),
				    user.getId()
				);

			if(cnt>0) {
				status = true;
			}
			else {
				status = false;
			}
		}
		catch(Exception e){
			status = false;
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean deleteUser(int id) {
		boolean status = false;
		try {
			String delete_query = "delete from users where id=?";
			int cnt = jdbcTemplate.update(delete_query, id);

			if(cnt>0) {
				status = true;
			}
			else {
				status = false;
			}
		}
		catch(Exception e){
			status = false;
			e.printStackTrace();
		}
		return status;
	}
	
	public User getUserByUser(int id) {
		String select_query = "Select * from users where id = ?";
		return jdbcTemplate.queryForObject(select_query, new UserRowMapper(), id);
	}
	
	//More than one record
	public List<User> getUsersData(){
		String select_query = "Select * from users";
		return jdbcTemplate.query(select_query, new UserRowMapper());
	}
	
	public User getUserById(int id) {
		String select_query = "Select * from users where id = ?";
		return jdbcTemplate.queryForObject(select_query, new UserRowMapper(), id);
	}
}
