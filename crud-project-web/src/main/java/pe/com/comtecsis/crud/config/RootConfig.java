package pe.com.comtecsis.crud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:db.properties", "classpath:app.properties"}, ignoreResourceNotFound = false)
@ComponentScan("pe.com.comtecsis.crud")
public class RootConfig {
    
}
