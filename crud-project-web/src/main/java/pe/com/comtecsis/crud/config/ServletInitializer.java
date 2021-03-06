package pe.com.comtecsis.crud.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import pe.com.comtecsis.crud.security.SecurityConfig;
import pe.com.comtecsis.crud.security.SessionConfig;

public class ServletInitializer extends
	AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class[] { SpringPropertiesConfig.class, 
		RootConfig.class, SqlSessionConfig.class, ConfigMvc.class, SessionConfig.class, SecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
	return null;
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] { "/" };
    }

    @Override
    protected DispatcherServlet createDispatcherServlet(
	    WebApplicationContext servletAppContext) {
	final DispatcherServlet dispatcherServlet = (DispatcherServlet) super
		.createDispatcherServlet(servletAppContext);
	dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
	return dispatcherServlet;
    }
}
