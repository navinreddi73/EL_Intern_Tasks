package in.edify.main.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.edify.main.entities.User;

public class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User user1 = new User();
			user1.setId(rs.getInt("id"));
			user1.setEmail(rs.getString("email"));
			user1.setName(rs.getString("name"));
			user1.setPassword(rs.getString("password"));
			return user1;
		}
	}
