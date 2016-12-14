package com.alithya.shoppingcard.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.alithya.shoppingcard.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository{


	private JdbcTemplate template;
	
	public static final String FIND_ALLUSERS = "select * from user_table";
	
	@Autowired
	public UserRepositoryImpl(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	
	}

	@Override
	public  List<User> getRoles() {
	
		return template.query(FIND_ALLUSERS, new UserMapper());
	}
	
	private class UserMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			return new User(resultSet.getString("role"));
		}
		
	}
	

}
