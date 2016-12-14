package com.alithya.shoppingcard.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.alithya.shoppingcard.entity.User;
import com.alithya.shoppingcard.repository.UserRepository;
import com.alithya.shoppingcard.service.UserService;
import com.alithya.shoppingcard.service.UserServiceImpl;

public class UserServiceImplTest {

	@InjectMocks
	private UserService userService = new UserServiceImpl();

	@Mock
	private UserRepository userRepository;

	private List<User> userList;
	private User user1;
	private User user2;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		userList = new ArrayList<>();
		user1 = new User();
		user1.setRole("admin");
		userList.add(user1);
		user2 = new User();
		user2.setRole("client");
		userList.add(user2);

	}

	@Test
	public void testMockCreation() {
		assertNotNull(userRepository);
	}

	@Test
	public void testGetUserRole() {
		when(userRepository.getRoles()).thenReturn((List<User>) userList);
		assertNotNull(userService.getUserRoles());
	}

	@Test
	public void testReturnAdminPage() {
		when(userRepository.getRoles()).thenReturn((List<User>) userList);
		userService.getUserRoles();
		assertEquals("adminFirstPage", userService.returnCorrectPage("admin"));
	}

	@Test
	public void testReturnClientPage() {
		when(userRepository.getRoles()).thenReturn((List<User>) userList);
		userService.getUserRoles();
		assertEquals("userFirstPage", userService.returnCorrectPage("client"));
	}
	
	@Test
	public void testReturnHomePage() {
		when(userRepository.getRoles()).thenReturn((List<User>) userList);
		userService.getUserRoles();
		assertEquals("home", userService.returnCorrectPage("user"));
	}

}
