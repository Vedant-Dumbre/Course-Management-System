package org.tech.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="org.tech")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

	
	@Bean
	public InternalResourceViewResolver getviewResolver()
	{
		InternalResourceViewResolver rv=new InternalResourceViewResolver();
		rv.setPrefix("/WEB-INF/views/");
		rv.setSuffix(".jsp");
		return rv;
	}
	
	 
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**")
	                .addResourceLocations("/resources/");
	        
	        registry.addResourceHandler("/PDF/**")
            .addResourceLocations("/PDF/");
	        
	    }
	
	 @Bean
	 public StandardServletMultipartResolver multipartResolver()
	 {
		return new StandardServletMultipartResolver() ;
		 
	 }
}
