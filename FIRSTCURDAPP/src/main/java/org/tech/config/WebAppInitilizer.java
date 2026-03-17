package org.tech.config;

import java.io.File;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebAppInitilizer implements WebApplicationInitializer {
	
	public static String pdfFilePath;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);
		context.setServletContext(servletContext);
		context.refresh();
		DispatcherServlet ds=new DispatcherServlet(context);
		ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher", ds);
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
		//String path=servletContext.getRealPath("/");
		File pdfFile=new File("C:\\Users\\VEDANT\\eclipse-workspace\\SpringMVC\\FIRSTCURDAPP\\src\\main\\webapp\\PDF");
		pdfFilePath=pdfFile.toString();
		
		if(!pdfFile.exists())
		{
			pdfFile.mkdir();
		}
		
		MultipartConfigElement MPC=new MultipartConfigElement("C:\\Users\\VEDANT\\eclipse-workspace\\SpringMVC\\FIRSTCURDAPP\\src\\main\\webapp\\PDF",		//folder location where images get store
				10*1024*1024, 		//max size of file(2mb)
				 20*1024*1024,		//max requestsize of file(20mb)
				 0);				//file size threshold
		
		servlet.setMultipartConfig(MPC);
		
		AnnotationConfigWebApplicationContext context1=new AnnotationConfigWebApplicationContext();
		context.register(DBConfig.class);
		
	}
	

}
