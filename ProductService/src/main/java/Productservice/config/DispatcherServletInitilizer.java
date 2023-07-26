package org.mani.Productservice.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class DispatcherServletInitilizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(AppConfig.class);
		 DispatcherServlet servlet = new DispatcherServlet(applicationContext);
		 Dynamic addServlet = servletContext.addServlet("dispatcherServlet",servlet);
		 addServlet.addMapping("/");
		 addServlet.setLoadOnStartup(1);
	}

}
