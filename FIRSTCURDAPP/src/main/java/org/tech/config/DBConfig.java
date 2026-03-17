package org.tech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {
	
	@Bean(name="datasource")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource d= new DriverManagerDataSource();
		d.setDriverClassName("com.mysql.cj.jdbc.Driver");
		d.setUsername("root");
		d.setPassword("vedant");
		d.setUrl("jdbc:mysql://localhost:3306/crudmvc");
		
		return d;
	}
	
	@Bean(name="template")
	public JdbcTemplate getTemplate()
	{
		return new JdbcTemplate(getDataSource());
	}

}
