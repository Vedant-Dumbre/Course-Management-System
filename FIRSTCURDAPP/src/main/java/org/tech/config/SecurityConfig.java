package org.tech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception
	{
		http.csrf().disable();
		
		http.authorizeHttpRequests(auth->auth.anyRequest().permitAll())
				/*requestMatchers("/","/WEB-INF/views/**","/resources/**").         //first it will start with default page then it will allow all files in view and resources
				permitAll().anyRequest().
				authenticated())*/
		.formLogin(form->form.loginPage("/log").            // it calls the login page when we click on log 
						loginProcessingUrl("/login").								//after click on login button login page/jsp will open
						defaultSuccessUrl("/index",true).permitAll()).				//after successfull login index page should open
		logout(logout->logout.
				
				logoutSuccessUrl("/log?logout=true").
				permitAll());
		
		return http.build();
		
	}
	
	

}
