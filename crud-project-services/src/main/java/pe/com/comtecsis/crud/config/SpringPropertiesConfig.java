package pe.com.comtecsis.crud.config;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.jndi.JndiTemplate;

/**
 * Example of Spring 4 Properties Java Configuration, with a Database Properties
 * table to store most values and a small application.properties file too. The
 * Database table will take precedence over the properties file with this setup
 */

@Configuration
public class SpringPropertiesConfig{

    private static final Logger logger = LoggerFactory
	    .getLogger(SpringPropertiesConfig.class);

    /**
     * Read why this is required:
     * http://www.baeldung.com/2012/02/06/properties-with-spring/#java It is
     * important to be static:
     * http://www.java-allandsundry.com/2013/07/spring-bean
     * -and-propertyplaceholderconf.html
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	return new PropertySourcesPlaceholderConfigurer();
    }

    @PostConstruct
    public void initialize() {
    }

}