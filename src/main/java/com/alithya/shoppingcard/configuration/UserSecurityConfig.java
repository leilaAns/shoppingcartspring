package com.alithya.shoppingcard.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    public void configureAuth(AuthenticationManagerBuilder auth)throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
        		.and().withUser("admin").password("admin").roles("ADMIN");
         
    }
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
  
      http.authorizeRequests()
        .antMatchers("/adminFirstPage").hasRole("ADMIN")
        .antMatchers("/userFirstPage").hasRole("USER")
        .antMatchers("/userFirstPage").hasRole("USER")
        .and().formLogin();

    }
	

}
