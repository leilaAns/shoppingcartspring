package com.alithya.shoppingcard.configuration;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

public class ShoppingOnlineWebAppInitializer {
/*
@Override
public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
        webAppContext.register(MyDispatcherServlet.class);
        webAppContext.register(WebServiceConfig.class);
        
DispatcherServlet dispatcherServlet = new DispatcherServlet();

dispatcherServlet.setContextConfigLocation("");
dispatcherServlet.setApplicationContext(webAppContext);
ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet", dispatcherServlet);
appServlet.setLoadOnStartup(1);

MessageDispatcherServlet mds = new MessageDispatcherServlet();
mds.setTransformWsdlLocations(true);
mds.setApplicationContext(webAppContext);
mds.setTransformWsdlLocations(true);
mds.setContextConfigLocation("");

ServletRegistration.Dynamic mdsServlet = servletContext.addServlet("mdsServlet", mds);
mdsServlet.addMapping("/ws/*");
mdsServlet.addMapping("*.wsdl");
mdsServlet.setLoadOnStartup(2);
}
*/
}

