package pe.com.comtecsis.crud.config;

import java.text.MessageFormat;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.configuration.ConfigurationConverter;
import org.apache.commons.configuration.DatabaseConfiguration;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Example of Spring 4 Properties Java Configuration, with a Database Properties
 * table to store most values and a small application.properties file too. The
 * Database table will take precedence over the properties file with this setup
 */

@Configuration
public class SpringPropertiesConfig{

    private static final Logger logger = LoggerFactory
	    .getLogger(SpringPropertiesConfig.class);

    @Autowired
    private org.springframework.core.env.Environment env;

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

    @Bean
    public DataSource dataSource() throws NamingException {
    	return (DataSource) new JndiTemplate().lookup("jdbc/oracle");
	/*BasicDataSource dataSource = 
			new BasicDataSource();
	dataSource.setDriverClassName(env
		.getProperty("datasource.driverClassName"));
	dataSource.setUrl(env.getProperty("datasource.url"));
	dataSource.setUsername(env.getProperty("datasource.username"));
	dataSource.setPassword(env.getProperty("datasource.password"));
	return dataSource;*/
    }

    @PostConstruct
    public void initialize() {

	try {
	    DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(
		    dataSource(), "appconfiguration", "propertykey",
		    "propertyvalue");
	    Properties dbProps = ConfigurationConverter
		    .getProperties(databaseConfiguration);
	    PropertiesPropertySource dbPropertySource = new PropertiesPropertySource(
		    "dbPropertySource", dbProps);
	    MutablePropertySources propertySources = ((ConfigurableEnvironment) env)
		    .getPropertySources();
	    propertySources.addFirst(dbPropertySource);
	} catch (Exception e) {
	    logger.error("Error during database properties setup", e);
	    throw new RuntimeException(e);
	}
    }

}