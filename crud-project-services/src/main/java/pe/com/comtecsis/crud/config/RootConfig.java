package pe.com.comtecsis.crud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@PropertySource(value = {"${crud-path}/db.properties", "${crud-path}/app.properties"}, ignoreResourceNotFound = false)
@ComponentScan("pe.com.comtecsis.crud")
public class RootConfig {

	@Value("${crud-path}")
    private String crudPath;
	    
    @Bean
    public ReloadableResourceBundleMessageSource messageSource()
    {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasenames(new String[] { 
	    		crudPath+"/i18n/crud" });
	    messageSource.setFallbackToSystemLocale(true);
	    messageSource.setAlwaysUseMessageFormat(true);
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
    }
}
