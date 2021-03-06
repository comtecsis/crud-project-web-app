package pe.com.comtecsis.crud.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import pe.com.comtecsis.crud.util.UtilWebConstants;

/**
 * Configuracion de thymeleaf.
 */
@Configuration
@EnableWebMvc
public class ConfigMvc extends WebMvcConfigurerAdapter
{
	
    private static final String PATH_TEMPLATES_THYMELEAF = "/WEB-INF/templates/";
    private static final String SUFFIX_HTML_THYMELEAF = ".html";

    @Value("${crud-path}")
    private String crudPath;
    
    @Bean
    public ITemplateResolver templateResolver()
    {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix(PATH_TEMPLATES_THYMELEAF);
        resolver.setSuffix(SUFFIX_HTML_THYMELEAF);
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCacheable(true);                
        return resolver;
    }

    @Bean
    public TemplateEngine templateEngine()
    {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        engine.addDialect(new SpringSecurityDialect());
        return engine;
    }

    @Bean
    public ViewResolver viewResolver()
    {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding(UtilWebConstants.ENCODING_UTF_8);
        resolver.setCache(true);
        resolver.setRedirectHttp10Compatible(false);
        return resolver;
    }

    
    @Bean
    public LocaleResolver localeResolver()
    {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(Locale.forLanguageTag(UtilWebConstants.LOCALE_ES_PE));
        resolver.setCookieName(UtilWebConstants.COOKIE_TB_LOCALE);
        resolver.setCookieMaxAge(-1);
        resolver.setCookieHttpOnly(true);
        return resolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor()
    {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName(UtilWebConstants.PARAMETER_LOCALE);
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource()
    {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasenames(new String[] { 
	    		crudPath+"/i18n/crud" });
	    messageSource.setFallbackToSystemLocale(true);
	    messageSource.setAlwaysUseMessageFormat(true);
	    messageSource.setDefaultEncoding(UtilWebConstants.ENCODING_UTF_8);
	    return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**").addResourceLocations(UtilWebConstants.RESOURCES_LOCATION);
    }
    
    
    @Bean
    public HandlerExceptionResolver theResolver(){
       SimpleMappingExceptionResolver s = new SimpleMappingExceptionResolver();
       s.setDefaultErrorView("error/error_template");
       return s;
    }
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
    }
    
    
}