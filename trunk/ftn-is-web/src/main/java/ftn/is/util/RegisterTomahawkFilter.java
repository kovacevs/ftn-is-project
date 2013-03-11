package ftn.is.util;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.myfaces.webapp.filter.*;

@WebListener
public class RegisterTomahawkFilter implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Registuje se Tomahawk filter za fajl upload.");
		
		ServletContext ctx = sce.getServletContext();
		FilterRegistration fr = ctx.addFilter("FileUploadFilter", ExtensionsFilter.class);
		fr.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), true, "FacesServlet");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {		
	}
}