package pe.com.comtecsis.crud.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	
    private static final String URL_LOGOUT = "/logout/";
    private static final String URL_LOGIN = "/login/";
    private static final String URL_RESOURCES = "/resources/**";
    private static final String URL_LOGIN_PAGE_PERMIT = "/loginPage**";
    public static final String URL_LOGIN_PAGE = "/loginPage/";

    @Autowired 
    private LogoutHandler logoutHandler;

	@Autowired
	private AuthenticationProvider customAuthenticationProvider;
	
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public AuthenticationFailureHandler authentitactionFailureHandler() {
		return new SimpleUrlAuthenticationFailureHandler(
				URL_LOGIN_PAGE+"?auth=failure");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.debug("Configurando seguridad de acceso.");
        http    
        
        /*.requiresChannel()
        	.anyRequest().requiresSecure()
        	.and()*/
        .authorizeRequests()
          .antMatchers(URL_RESOURCES).permitAll()
          .antMatchers(URL_LOGIN_PAGE_PERMIT).permitAll()      
          //.antMatchers(URL_SELECT_COMPANY).access("@menuAccessCheck.hasCompany(authentication, request)")
          .anyRequest()
          .authenticated()
          .and()          
          .logout()
              .logoutUrl(URL_LOGOUT)
              .logoutSuccessUrl(URL_LOGIN_PAGE)
              .clearAuthentication(true)
              .deleteCookies("SESSION")
              .addLogoutHandler(logoutHandler)
              .permitAll()
          .and()
          .formLogin()
            .loginPage(URL_LOGIN_PAGE)
            .loginProcessingUrl(URL_LOGIN)
            .defaultSuccessUrl("/", true)
            .usernameParameter("username")
            .passwordParameter("password")
            .failureUrl(URL_LOGIN_PAGE)
            .failureHandler(authentitactionFailureHandler())
            .permitAll()
            
        .and()
            .exceptionHandling()
            .authenticationEntryPoint(new AccessDeniedEntryPoint(URL_LOGIN_PAGE))
            .accessDeniedHandler(accessDeniedHandler);

	}

}
