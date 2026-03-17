package org.tech.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class UserConfig {
	
	
	 @Autowired 
	 DataSource dataSource;
	 
	
	
	
	@Bean
	public UserDetailsService userDetailService()
	{
		JdbcUserDetailsManager manager=new JdbcUserDetailsManager(dataSource);
		
		UserDetails user=User.withDefaultPasswordEncoder().
				username("ram").
				password("12345").
				roles("admin").
				build();
		
		return new InMemoryUserDetailsManager(user);
	}
	
	
	  @Bean 
	  public PasswordEncoder passwordEncoder() 
	  { 
		  
		  return new BCryptPasswordEncoder(); 
	  
	  }
	 

}
