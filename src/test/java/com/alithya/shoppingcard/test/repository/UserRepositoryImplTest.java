package com.alithya.shoppingcard.test.repository;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.alithya.shoppingcard.configuration.MyDataSourceConfig;
import com.alithya.shoppingcard.entity.User;
import com.alithya.shoppingcard.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyDataSourceConfig.class)
@Transactional
@ActiveProfiles("test")
public class UserRepositoryImplTest {

	@Autowired
	private UserRepository userRepositroy;

	@Test
	public void testGetRoles() {
		List<User> users = userRepositroy.getRoles();
		assertEquals(users.size(), 2);
		assertEquals(users.get(0).getRole(), "admin");
		assertEquals(users.get(1).getRole(), "client");
	}

}
