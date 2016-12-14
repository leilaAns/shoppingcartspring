package com.alithya.shoppingcard.test.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.alithya.shoppingcard.configuration.MyDispatcherServlet;
import com.alithya.shoppingcard.configuration.MyWebAppContextConfig;
import com.alithya.shoppingcard.controller.HomeController;
import com.alithya.shoppingcard.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MyDispatcherServlet.class, MyWebAppContextConfig.class })
@WebAppConfiguration
public class HomeControllerTest {

	@InjectMocks
	private HomeController homeController;

	private User user;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		user = new User();

	}

	@Test
	public void testGoHome() {
		assertSame("retrun the correct page", "home", homeController.goHome(user));
		user.setRole("admin");
		assertSame("retrun the correct page", "adminFirstPage", homeController.goHome(user));
		user.setRole("user");
		assertSame("retrun the correct page", "userFirstPage", homeController.goHome(user));

	}

}
