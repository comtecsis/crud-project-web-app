package pe.com.comtecsis.crud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:app.properties")
@ComponentScan("pe.com.comtecsis.crud")
public class RootConfig {

}
