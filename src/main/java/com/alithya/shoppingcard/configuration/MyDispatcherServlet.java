package com.alithya.shoppingcard.configuration;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{
				MyWebAppContextConfig.class,MyDataSourceConfig.class
				};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{
				MyDispatcherServlet.class
				};

	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.setInitParameter("spring.profiles.active", "test");
	}
}
